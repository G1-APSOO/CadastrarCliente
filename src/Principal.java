import conexaoBanco.ConexaoMySQL;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Bem vindo, testando conexão!");
		
		
		ConexaoMySQL connection = new ConexaoMySQL();
		System.out.println(connection.statusConection());

		connection.getConexaoMySQL();
		System.out.println(connection.statusConection());
		
		System.out.println("Inserindo Cliente");
		connection.InserirCliente();
		System.out.println("Cliente inserido com sucesso");
		
		
		
		connection.FecharConexao();
	
	}
}
