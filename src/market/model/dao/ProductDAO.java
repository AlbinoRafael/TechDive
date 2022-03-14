package market.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import market.model.entities.Product;

public class ProductDAO {

	private Connection conn;

	public ProductDAO(Connection conn) {
		this.conn = conn;
	}

	public void list() throws SQLException {
		PreparedStatement statement = conn.prepareStatement("select id, name, descricao from produto;");
		statement.execute();

		ResultSet resultSet = statement.getResultSet();
		int count = 0;
		while (resultSet.next()) {
			count++;
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String descricao = resultSet.getString("descricao");
			System.out.println(
					"Produto " + count + ": id={" + id + "}, name={" + name + "}, descricao={" + descricao + "}");
		}
	}

	public boolean create(Product product) {
		try (PreparedStatement preparedStatement = conn
				.prepareStatement("insert into produto(name,descricao)values(?,?)")) {

			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao criar produto. Causado por: " + e.getMessage());
			// e.printStackTrace();
			return false;
		}
		System.out.println("Produto criado com sucesso!");
		return true;
	}

	public boolean delete(Product product) {

		try {
			String sql = "delete from produto where id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, product.getId());
			statement.execute();

			int updateCount = statement.getUpdateCount();

			if (updateCount == 0) {
				System.out.println("Produto não encontrado no banco. Produto não deletado.");
				return false;
			} else {
				System.out.println("Produto deletado com sucesso!");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao deletar um produto. Causado por: " + e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

}
