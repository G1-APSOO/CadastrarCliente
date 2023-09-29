package conexaoBanco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import classes.Cliente;
import classes.UnidadeFederativa;

public class ClienteDAO {

	public static boolean inserirCliente(Cliente cliente) {

		String sql = "INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
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
				System.out.println("Cliente inserido com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static Cliente buscarCliente(String CPF) {

		String sql = "SELECT * FROM Cliente WHERE CPF = ?";

		try {

			PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
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

	public static boolean atualizarCliente(Cliente cliente) {

		String sql = "UPDATE Cliente SET nome = ?, rua = ?, bairro = ?, cidade = ?, email = ?, dataDeNascimento = ?, numeroResidencia = ?, telefone = ?, unidadeFederativa = ? WHERE CPF = ?";

		try {

			PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getRua());
			statement.setString(3, cliente.getBairro());
			statement.setString(4, cliente.getCidade());
			statement.setString(5, cliente.getEmail());
			statement.setString(6, cliente.getDataNascimento().getData());
			statement.setInt(7, cliente.getNumeroResidencia());
			statement.setString(8, cliente.getTelefone());
			statement.setInt(9, cliente.getUF().ordinal());
			statement.setString(10, cliente.getCPF());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Cliente atualizado com sucesso!");
			}
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean deletarCliente(String CPF) {
		String sql = "DELETE FROM Cliente WHERE CPF = ?";

		try {

			PreparedStatement statement = Conexao.getConexao().prepareStatement(sql);
			statement.setString(1, CPF);

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Cliente deletado com sucesso!");
			}
			return true;

		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
}
