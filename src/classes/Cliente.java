package classes;

import java.util.regex.Pattern;

import excecoes.ExcecaoCPFInvalido;
import excecoes.ExcecaoAnoInvalido;
import excecoes.ExcecaoAtributoVazio;
import excecoes.ExcecaoDiaInvalido;
import excecoes.ExcecaoEmailInvalido;
import excecoes.ExcecaoMesInvalido;
import excecoes.ExcecaoNaoPreenchido;
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
	throws ExcecaoNaoPreenchido,
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

	public void setCPF(String novoCPF) throws ExcecaoNaoPreenchido, ExcecaoCPFInvalido {
				
		if (novoCPF == null || novoCPF.isEmpty() || novoCPF.isBlank()) throw new ExcecaoNaoPreenchido("CPF");
		
		boolean eValido = ValidadorCPF.isCPF(novoCPF);
		
		if (eValido == false) throw new ExcecaoCPFInvalido();

		
		CPF = novoCPF;
	}

	public void setNome(String nome) throws ExcecaoNaoPreenchido, ExcecaoSomenteLetrasPermitidas {
		
		if (nome == null || nome.isEmpty() || nome.isBlank()) throw new ExcecaoNaoPreenchido("Nome não está preenchido");
		if (nome.matches("[a-zA-Z]+( [a-zA-Z]+)*") == false) throw new ExcecaoSomenteLetrasPermitidas("nome");
		
		this.nome = nome;
	}

	public void setRua(String rua) throws ExcecaoNaoPreenchido, ExcecaoSomenteLetrasPermitidas {
		
		if (rua == null || rua.isEmpty() || rua.isBlank()) throw new ExcecaoNaoPreenchido("rua");
		
		this.rua = rua;
	}

	public void setBairro(String bairro) throws ExcecaoNaoPreenchido, ExcecaoSomenteLetrasPermitidas {
		
		if (bairro == null || bairro.isEmpty() || bairro.isBlank()) throw new ExcecaoNaoPreenchido("bairro");
		
		this.bairro = bairro;
	}

	public void setCidade(String cidade) throws ExcecaoNaoPreenchido, ExcecaoSomenteLetrasPermitidas {
		
		if (cidade == null || cidade.isEmpty() || cidade.isBlank()) throw new ExcecaoNaoPreenchido("cidade");
		if (cidade.matches("[a-zA-Z]+( [a-zA-Z]+)*") == false) throw new ExcecaoSomenteLetrasPermitidas("cidade");
		
		this.cidade = cidade;
	}
	
	public void setEmail(String email) throws ExcecaoNaoPreenchido, ExcecaoEmailInvalido {
		
		if (email == null || email.isEmpty() || email.isBlank()) throw new ExcecaoNaoPreenchido("email");
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
                  
		boolean emailValido = Pattern.matches(emailRegex, email);
		if (emailValido == false) throw new ExcecaoEmailInvalido();

		this.email = email;
	}

	public void setNumeroResidencia(int numeroResidencia) throws ExcecaoSomenteNumerosPositivosPermitidos {
		
		if (numeroResidencia <= 0) throw new ExcecaoSomenteNumerosPositivosPermitidos();
		
		this.numeroResidencia = numeroResidencia;
	}
	
	public void setTelefone(String telefone) throws ExcecaoNaoPreenchido, ExcecaoTelefoneInvalido {
		
		if (telefone == null || telefone.isEmpty() || telefone.isBlank()) throw new ExcecaoNaoPreenchido("telefone");
		if (telefone.length() != 11) throw new ExcecaoTelefoneInvalido();
		
		this.telefone = telefone;
	}
	
	public void setUF(UnidadeFederativa novaUF) {
		
		if (novaUF == null) throw new ExcecaoNaoPreenchido("unidade federativa");
		
		this.UF = novaUF;
	}
	
	public void setDataNascimento(int dia, int mes, int ano) 
	throws ExcecaoNaoPreenchido,
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

	public String getRua() throws ExcecaoAtributoVazio {
		
		if (rua == null) throw new ExcecaoAtributoVazio("rua");
		
		return rua;
	}
	
	public String getBairro() throws ExcecaoAtributoVazio {
		
		if (bairro == null) throw new ExcecaoAtributoVazio("bairro");
		
		return bairro;
	}
	
	public String getCidade() throws ExcecaoAtributoVazio {
		
		if (cidade == null) throw new ExcecaoAtributoVazio("cidade");
		
		return cidade;
	}

	public int getNumeroResidencia() throws ExcecaoAtributoVazio {
		
		if (numeroResidencia == 0) throw new ExcecaoAtributoVazio("numero da residencia");
		
		return numeroResidencia;
	}

	public Data getDataNascimento() {
		return dataDeNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public UnidadeFederativa getUF() throws ExcecaoAtributoVazio {
		
		if (UF == null) throw new ExcecaoAtributoVazio("unidade federativa");
		
		return UF;
	}
	
}
