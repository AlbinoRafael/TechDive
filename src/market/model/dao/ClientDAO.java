package market.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import market.model.entities.Client;

public class ClientDAO {

	private Connection conn;

	public ClientDAO(Connection conn) {
		this.conn = conn;
	}

	public void list() throws SQLException {
		Statement statement = conn.createStatement();
		statement.execute("select id_cliente, nome, cpf from cliente;");

		ResultSet resultSet = statement.getResultSet();
		int count = 0;
		while (resultSet.next()) {
			count++;
			int id = resultSet.getInt("id_cliente");
			String name = resultSet.getString("nome");
			String cpf = resultSet.getString("cpf");
			System.out.println("Cliente " + count + ": id={" + id + "}, name={" + name + "}, cpf={" + cpf + "}");
		}
	}

	public boolean create(Client client) {
		try (PreparedStatement preparedStatement = conn.prepareStatement("insert into cliente(nome,cpf)values(?,?)")) {

			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getCpf());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao criar cliente. Causado por: " + e.getMessage());
			// e.printStackTrace();
			return false;
		}
		System.out.println("Cliente criado com sucesso!");
		return true;
	}

	public boolean delete(Client client) {

		try {
			String sql = "delete from cliente where id_cliente = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, client.getId());
			statement.execute();

			int updateCount = statement.getUpdateCount();

			if (updateCount == 0) {
				System.out.println("Cliente não encontrado no banco. Cliente não deletado.");
				return false;
			} else {
				System.out.println("Cliente deletado com sucesso!");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao deletar um cliente. Causado por: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
