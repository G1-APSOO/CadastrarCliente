import classes.Cliente;
import classes.UnidadeFederativa;
import conexaoBanco.ClienteDAO;
import conexaoBanco.Conexao;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Bem vindo, testando conexão!");

		Cliente c = new Cliente("08010842109", "Pedro Paulo Araujo", "pedroapsilva22@gmail.com", "99881718", 13, 05,
				2002);
		c.setBairro("Centro");
		c.setCidade("Terenos");
		c.setRua("Gumercindo");
		c.setNumeroResidencia(1061);
		c.setUF(UnidadeFederativa.MS);

		System.out.println(Conexao.statusConection());

		// inserção
		System.out.println("Inserindo Cliente");
		System.out.println(ClienteDAO.inserirCliente(c));

		// busca
		System.out.println("Bucando cliente:");
		Cliente c2 = ClienteDAO.buscarCliente("08010842109");

		System.out.println(c2.getNome());
		System.out.println(c2.getTelefone());
		System.out.println(c2.getDataNascimento().getData());

		// atualização
		c2.setNome("Pedro Paulo Araujo Silva");

		System.out.println("Atualizando Cliente");
		System.out.println(ClienteDAO.atualizarCliente(c2));

		// deleção
		// System.out.println("Deletando Cliente");
		// System.out.println(ClienteDAO.deletarCliente("08010842109"));

		Conexao.FecharConexao();

	}
}
