package classes;
import excessoes.ExcessaoClienteMuitoAntigo;
import excessoes.ExcessaoClienteMuitoNovo;
import excessoes.ExcessaoDiaInvalido;
import excessoes.ExcessaoEmailInvalido;
import excessoes.ExcessaoMesInvalido;
import excessoes.ExcessaoCPFInvalido;
import excessoes.ExcessaoSomenteLetrasPermitidas;
import excessoes.ExcessaoSomenteNumerosPositivosPermitidos;
import excessoes.ExcessaoTelefoneInvalido;
import excessoes.ExcessaoParametroVazio;

import java.util.regex.Pattern;

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
	throws ExcessaoParametroVazio,
		ExcessaoDiaInvalido,
		ExcessaoMesInvalido,
		ExcessaoClienteMuitoNovo,
		ExcessaoClienteMuitoAntigo,
		ExcessaoCPFInvalido,
		ExcessaoSomenteLetrasPermitidas,
		ExcessaoEmailInvalido,
		ExcessaoSomenteNumerosPositivosPermitidos,
		ExcessaoTelefoneInvalido {
		
		setCPF(CPF);
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);
		setDataNascimento(diaDoNascimento, mesDoNascimento, anoDoNascimento);
		
	} 
	

	public void setCPF(String novoCPF) throws ExcessaoParametroVazio, ExcessaoCPFInvalido {
		
		if (novoCPF == null || novoCPF.isEmpty() || novoCPF.isBlank()) {
			throw new ExcessaoParametroVazio("CPF");
		}
		
		boolean eValido = ValidadorCPF.isCPF(novoCPF);
		
		if (eValido == false) throw new ExcessaoCPFInvalido();
		
		CPF = novoCPF;
	}

	public void setNome(String nome) throws ExcessaoParametroVazio, ExcessaoSomenteLetrasPermitidas {
		
		if (nome == null || nome.isEmpty() || nome.isBlank()) {
			throw new ExcessaoParametroVazio("nome");
		}
		
		if (nome.matches("[a-zA-Z]+") == false) {
			throw new ExcessaoSomenteLetrasPermitidas();
		}
		
		this.nome = nome;
	}

	public void setRua(String rua) throws ExcessaoParametroVazio, ExcessaoSomenteLetrasPermitidas {
		
		if (rua == null || rua.isEmpty() || rua.isBlank()) {
			throw new ExcessaoParametroVazio("rua");
		}
		
		if (rua.matches("[a-zA-Z]+") == false) {
			throw new ExcessaoSomenteLetrasPermitidas();
		}
		
		this.rua = rua;
	}

	public void setBairro(String bairro) throws ExcessaoParametroVazio, ExcessaoSomenteLetrasPermitidas {
		
		if (bairro == null || bairro.isEmpty() || bairro.isBlank()) {
			throw new ExcessaoParametroVazio("bairro");
		}
		
		if (bairro.matches("[a-zA-Z]+") == false) {
			throw new ExcessaoSomenteLetrasPermitidas();
		}
		
		this.bairro = bairro;
	}

	public void setCidade(String cidade) throws ExcessaoParametroVazio, ExcessaoSomenteLetrasPermitidas {
		
		if (cidade == null || cidade.isEmpty() || cidade.isBlank()) {
			throw new ExcessaoParametroVazio("cidade");
		}
		
		if (cidade.matches("[a-zA-Z]+") == false) {
			throw new ExcessaoSomenteLetrasPermitidas();
		}
		
		this.cidade = cidade;
	}
	
	public void setEmail(String email) throws ExcessaoParametroVazio, ExcessaoEmailInvalido {
		
		if (email == null || email.isEmpty() || email.isBlank()) {
			throw new ExcessaoParametroVazio("email");
		}
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
                  
		Pattern pat = Pattern.compile(emailRegex);
		if (pat.matcher(email).matches() == false) {
			throw new ExcessaoEmailInvalido();
		}
		
		this.email = email;
	}
	
	public void setNumeroResidencia(int numeroResidencia) throws ExcessaoSomenteNumerosPositivosPermitidos {
		
		if (numeroResidencia <= 0) {
			throw new ExcessaoSomenteNumerosPositivosPermitidos();
		}
		
		this.numeroResidencia = numeroResidencia;
	}
	
	public void setTelefone(String telefone) throws ExcessaoParametroVazio, ExcessaoTelefoneInvalido {
		
		if (telefone == null || telefone.isEmpty() || telefone.isBlank()) {
			throw new ExcessaoParametroVazio("telefone");
		}
		
		if (telefone.length() < 8 || telefone.length() > 11) {
			throw new ExcessaoTelefoneInvalido();
		}
		
		this.telefone = telefone;
	}
	
	public void setUF(UnidadeFederativa novaUF) {
		this.UF = novaUF;
	}
	
	public void setDataNascimento(int dia, int mes, int ano) 
	throws ExcessaoParametroVazio,
		ExcessaoDiaInvalido,
		ExcessaoMesInvalido, 
		ExcessaoClienteMuitoAntigo,
		ExcessaoClienteMuitoNovo {
		
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
