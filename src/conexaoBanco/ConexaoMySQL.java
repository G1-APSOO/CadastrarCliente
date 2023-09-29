//Nome do nosso pacote //
package conexaoBanco;

//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Cliente;
import classes.UnidadeFederativa;

//Início da classe de conexão//

public class ConexaoMySQL {
	public static String status = "Não conectou...";

	// Método Construtor da Classe//
	public ConexaoMySQL() {
	}

	// Método de Conexão//
	public static java.sql.Connection getConexaoMySQL() {

		Connection connection = null; // atributo do tipo Connection
		try {
			// Carregando o JDBC Driver padrão

			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);

			// Configurando a nossa conexão com um banco de dados//
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
			// Não conseguindo se conectar ao banco

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

	public static boolean InserirCliente(Cliente cliente) {

		String sql = "INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			PreparedStatement statement = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
			statement.setString(1, cliente.getCPF());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getRua());
			statement.setString(4, cliente.getBairro());
			statement.setString(5, cliente.getCidade());
			statement.setString(6, cliente.getEmail());
			statement.setString(7, cliente.getDataNascimento().getData());
			statement.setInt(8, cliente.getNumeroResidencia());
			statement.setString(9, cliente.getTelefone());
			statement.setInt(10, cliente.getUF().ordinal());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static Cliente BuscarCliente(String CPF) {

		String sql = "SELECT * FROM Cliente WHERE CPF = ?";

		try {

			PreparedStatement statement = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
			statement.setString(1, CPF);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					String data = rs.getString("dataDeNascimento");
					String[] dataPartes = data.split("/");

					Cliente c = new Cliente(rs.getString("CPF"), rs.getString("nome"), rs.getString("email"),
							rs.getString("telefone"), Integer.parseInt(dataPartes[0]), Integer.parseInt(dataPartes[1]),
							Integer.parseInt(dataPartes[2]));

					c.setBairro(rs.getString("bairro"));
					c.setCidade(rs.getString("cidade"));
					c.setRua(rs.getString("rua"));
					c.setNumeroResidencia(rs.getInt("numeroResidencia"));
					UnidadeFederativa uf = UnidadeFederativa.values()[rs.getInt("unidadeFederativa")];
					c.setUF(uf);
					return c;
				}
			}
			return null;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	// atualizar cliente

	public static boolean DeletarCliente(String CPF) {

		String sql = "DELETE FROM Cliente WHERE CPF = ?";

		try {

			PreparedStatement statement = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
			statement.setString(1, CPF);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
}
