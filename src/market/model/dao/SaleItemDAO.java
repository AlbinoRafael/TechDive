package market.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import market.model.entities.SaleItem;

public class SaleItemDAO {

	private Connection conn;

	public SaleItemDAO(Connection conn) {
		this.conn = conn;
	}

	public void list() throws SQLException {
		PreparedStatement statement = conn.prepareStatement("select id_item_venda,id_produto,id_venda, quantidade, valor_un, subtotal from item_venda;");
		statement.execute();

		ResultSet resultSet = statement.getResultSet();
		int count = 0;
		while (resultSet.next()) {
			count++;
			int id = resultSet.getInt("id_item_venda");
			int idProduct = resultSet.getInt("id_produto");
			int idSale = resultSet.getInt("id_venda");
			int amount = resultSet.getInt("quantidade");
			double unitPrice = resultSet.getDouble("valor_un");
			double subtotal = resultSet.getDouble("subtotal");
			System.out.println("Sale " + count + ": id={" + id + "}, product={" + idProduct + "},sale={"+idSale+"}, amount={"+amount+"}, unit_price={" + unitPrice
					+ "}, subtotal={" + subtotal + "}");
		}
	}

	public boolean create(SaleItem saleItem) {
		try (PreparedStatement preparedStatement = conn
				.prepareStatement("insert into item_venda(id_produto,id_venda, quantidade, valor_un, subtotal)values(?,?,?,?,?)")) {

			preparedStatement.setLong(1, saleItem.getProduct().getId());
			preparedStatement.setLong(2, saleItem.getSale().getId());
			preparedStatement.setInt(3, saleItem.getAmount());
			preparedStatement.setDouble(4, saleItem.getUnitPrice());
			preparedStatement.setDouble(5, saleItem.getSubtotal());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao criar item_venda. Causado por: " + e.getMessage());
			return false;
		}
		System.out.println("item_venda criado com sucesso!");
		return true;
	}

	public boolean delete(SaleItem saleitem) {

		try {
			String sql = "delete from item_venda where id_item_venda = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, saleitem.getId());
			statement.execute();

			int updateCount = statement.getUpdateCount();

			if (updateCount == 0) {
				System.out.println("item_venda não encontrado no banco. item_venda não deletado.");
				return false;
			} else {
				System.out.println("item_venda deletado com sucesso!");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao deletar um item_venda. Causado por: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
}
