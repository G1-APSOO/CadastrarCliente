//Nome do nosso pacote //
package conexaoBanco;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Início da classe de conexão//

public class ConexaoMySQL {
	public static String status = "Não conectou...";

	//Método Construtor da Classe//
	public ConexaoMySQL() {}

	//Método de Conexão//
	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection
		try {
			//Carregando o JDBC Driver padrão

			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);

			//Configurando a nossa conexão com um banco de dados//
			String serverName = "localhost"; // caminho do servidor do BD
			String mydatabase = "exgrupo"; // nome do seu banco de dados
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root"; // nome de um usuário de seu BD
			String password = "pedro1234"; // sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);

			// Testa sua conexão//
			if (connection != null) {
				status = ("STATUS--->Conectado com sucesso!");
			} else {
				status = ("STATUS--->Não foi possivel realizar conexão");
			}
			return connection;
			
		} catch (ClassNotFoundException e) { // Driver não encontrado
			System.out.println("O driver expecificado nao foi encontrado.");
			return null;
		} catch (SQLException e) {
			//Não conseguindo se conectar ao banco

			System.out.println("Nao foi possivel conectar ao Banco de Dados.");
			return null;
		}
	}

	// Método que retorna o status da sua conexão//

	public static String statusConection() {
		return status;
	}

	// Método que fecha sua conexão//
	public static boolean FecharConexao() {
		try {
			ConexaoMySQL.getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// Método que reinicia sua conexão//
	public static java.sql.Connection ReiniciarConexao() {
		FecharConexao();
		return ConexaoMySQL.getConexaoMySQL();
	}
	
	public static boolean InserirCliente(){
		
		String sql = "INSERT INTO Cliente VALUES ('08010842109','Pedro Paulo',\r\n"
				+ "'Gumercindo','Centro','Terenos','pedroapsilva22@gmail.com','13/05/2002',1061,\r\n"
				+ "99881718,02)";
		try {
			
			PreparedStatement statement = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
//			statement.setString(1, "bill");
//			statement.setString(2, "secretpass");
//			statement.setString(3, "Bill Gates");
//			statement.setString(4, "bill.gates@microsoft.com");
		
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
		
	}
