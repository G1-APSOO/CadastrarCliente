package classes;
import java.util.regex.Pattern;

import excecoes.ExcecaoCPFInvalido;
import excecoes.ExcecaoAnoInvalido;
import excecoes.ExcecaoDiaInvalido;
import excecoes.ExcecaoEmailInvalido;
import excecoes.ExcecaoMesInvalido;
import excecoes.ExcecaoParametroVazio;
import excecoes.ExcecaoSomenteLetrasPermitidas;
import excecoes.ExcecaoSomenteNumerosPositivosPermitidos;
import excecoes.ExcecaoTelefoneInvalido;

public class Cliente {
	
	private String CPF;
	private String nome;
	private String rua;
	private String bairro;
	private String cidade;
	private String email;
	private String telefone;
	
	private Data dataDeNascimento;
	
	private int numeroResidencia;
	
	private UnidadeFederativa UF;
	
	// Só tem um construtor pois: Aqui contêm o que é obrigatório
	// O que for além do obrigatório a gente coloca como setTanan após criar a instancia
	public Cliente(String CPF, String nome, String email, String telefone, 
			int diaDoNascimento, int mesDoNascimento, int anoDoNascimento)
	throws ExcecaoParametroVazio,
		ExcecaoDiaInvalido,
		ExcecaoMesInvalido,
		ExcecaoAnoInvalido,
		ExcecaoCPFInvalido,
		ExcecaoSomenteLetrasPermitidas,
		ExcecaoEmailInvalido,
		ExcecaoSomenteNumerosPositivosPermitidos,
		ExcecaoTelefoneInvalido {
		
		setCPF(CPF);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setDataNascimento(diaDoNascimento, mesDoNascimento, anoDoNascimento);
		
	} 
	

	public void setCPF(String novoCPF) throws ExcecaoParametroVazio, ExcecaoCPFInvalido {
		
		if (novoCPF == null || novoCPF.isEmpty() || novoCPF.isBlank()) {
			throw new ExcecaoParametroVazio("CPF");
		}
		
		boolean eValido = ValidadorCPF.isCPF(novoCPF);
		
		if (eValido == false) throw new ExcecaoCPFInvalido();
		
		CPF = novoCPF;
	}

	public void setNome(String nome) throws ExcecaoParametroVazio, ExcecaoSomenteLetrasPermitidas {
		
		if (nome == null || nome.isEmpty() || nome.isBlank()) {
			throw new ExcecaoParametroVazio("nome");
		}
		
		if (nome.matches("[a-zA-Z]+") == false) {
			throw new ExcecaoSomenteLetrasPermitidas();
		}
		
		this.nome = nome;
	}

	public void setRua(String rua) throws ExcecaoParametroVazio, ExcecaoSomenteLetrasPermitidas {
		
		if (rua == null || rua.isEmpty() || rua.isBlank()) {
			throw new ExcecaoParametroVazio("rua");
		}
		
		if (rua.matches("[a-zA-Z]+") == false) {
			throw new ExcecaoSomenteLetrasPermitidas();
		}
		
		this.rua = rua;
	}

	public void setBairro(String bairro) throws ExcecaoParametroVazio, ExcecaoSomenteLetrasPermitidas {
		
		if (bairro == null || bairro.isEmpty() || bairro.isBlank()) {
			throw new ExcecaoParametroVazio("bairro");
		}
		
		if (bairro.matches("[a-zA-Z]+") == false) {
			throw new ExcecaoSomenteLetrasPermitidas();
		}
		
		this.bairro = bairro;
	}

	public void setCidade(String cidade) throws ExcecaoParametroVazio, ExcecaoSomenteLetrasPermitidas {
		
		if (cidade == null || cidade.isEmpty() || cidade.isBlank()) {
			throw new ExcecaoParametroVazio("cidade");
		}
		
		if (cidade.matches("[a-zA-Z]+") == false) {
			throw new ExcecaoSomenteLetrasPermitidas();
		}
		
		this.cidade = cidade;
	}
	
	public void setEmail(String email) throws ExcecaoParametroVazio, ExcecaoEmailInvalido {
		
		if (email == null || email.isEmpty() || email.isBlank()) {
			throw new ExcecaoParametroVazio("email");
		}
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
                  
		Pattern pat = Pattern.compile(emailRegex);
		if (pat.matcher(email).matches() == false) {
			throw new ExcecaoEmailInvalido();
		}
		
		this.email = email;
	}
	
	public void setNumeroResidencia(int numeroResidencia) throws ExcecaoSomenteNumerosPositivosPermitidos {
		
		if (numeroResidencia <= 0) {
			throw new ExcecaoSomenteNumerosPositivosPermitidos();
		}
		
		this.numeroResidencia = numeroResidencia;
	}
	
	public void setTelefone(String telefone) throws ExcecaoParametroVazio, ExcecaoTelefoneInvalido {
		
		if (telefone == null || telefone.isEmpty() || telefone.isBlank()) {
			throw new ExcecaoParametroVazio("telefone");
		}
		
		if (telefone.length() < 8 || telefone.length() > 11) {
			throw new ExcecaoTelefoneInvalido();
		}
		
		this.telefone = telefone;
	}
	
	public void setUF(UnidadeFederativa novaUF) {
		this.UF = novaUF;
	}
	
	public void setDataNascimento(int dia, int mes, int ano) 
	throws ExcecaoParametroVazio,
		ExcecaoDiaInvalido,
		ExcecaoMesInvalido,
		ExcecaoAnoInvalido {
		
		dataDeNascimento = new Data(dia, mes, ano);
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getRua() {
		return rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}

	public int getNumeroResidencia() {
		return numeroResidencia;
	}

	public Data getDataNascimento() {
		return dataDeNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public UnidadeFederativa getUF() {
		return UF;
	}
	
}
