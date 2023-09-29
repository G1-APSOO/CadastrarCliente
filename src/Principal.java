import classes.Cliente;
import classes.UnidadeFederativa;
import conexaoBanco.ConexaoMySQL;

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

		ConexaoMySQL connection = new ConexaoMySQL();
		System.out.println(connection.statusConection());

		connection.getConexaoMySQL();
		System.out.println(connection.statusConection());

		System.out.println("Inserindo Cliente");
		System.out.println(connection.InserirCliente(c));

		System.out.println("bucando cliente:");
		Cliente c2 = connection.BuscarCliente("08010842109");
		System.out.println(c2.getNome());
		System.out.println(c2.getTelefone());

		connection.FecharConexao();

	}
}
