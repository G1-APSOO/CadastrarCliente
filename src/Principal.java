import classes.Cliente;
import classes.UnidadeFederativa;
import conexaoBanco.ConexaoMySQL;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Bem vindo, testando conexão!");
		
//		public Cliente(String CPF, String nome, String email, String telefone, 
//				int diaDoNascimento, int mesDoNascimento, int anoDoNascimento)
		
//		String sql = "INSERT INTO Cliente VALUES ('08010842109',"
//				+ "'Pedro Paulo',"
//				+ "'Gumercindo',"
//				+ "'Centro',"
//				+ "'Terenos',"
//				+ "'pedroapsilva22@gmail.com',"
//				+ "'13/05/2002',"
//				+ "1061,\r\n"
//				+ "99881718,"
//				+ "02)";
		
		Cliente c = new Cliente("08010842109","Pedro Paulo Araujo","pedroapsilva22@gmail.com","99881718",13,05,2002);
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
		
		connection.FecharConexao();
		
		
		
		
		
		
	
	}
}
