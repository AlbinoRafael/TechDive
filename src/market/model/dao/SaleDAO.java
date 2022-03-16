package market.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import market.model.entities.Client;
import market.model.entities.Product;
import market.model.entities.Sale;

public class SaleDAO {

	private Connection conn;

	public SaleDAO(Connection conn) {
		this.conn = conn;
	}

	public void list() throws SQLException {
		PreparedStatement statement = conn.prepareStatement("select id_venda, id_cliente, valor, data from venda;");
		statement.execute();

		ResultSet resultSet = statement.getResultSet();
		int count = 0;
		while (resultSet.next()) {
			count++;
			int id = resultSet.getInt("id_venda");
			int idClient = resultSet.getInt("id_cliente");
			double price = resultSet.getDouble("valor");
			Date data = resultSet.getDate("data");
//			System.out.println("Sale " + count + ": id={" + id + "}, client={" + idClient + "}, price={" + price
//					+ "}, date={" + data + "}");
			System.out.printf("%-15s %16s %13s %-15s %5s %-15s %n", count + " - Venda "+idClient,id," ",price," ",data);
		}
	}

	public boolean create(Sale sale) {
		try (PreparedStatement preparedStatement = conn
				.prepareStatement("insert into venda(id_cliente,valor,data)values(?,?,?)")) {

			preparedStatement.setLong(1, sale.getClient().getId());
			preparedStatement.setDouble(2, sale.getPrice());
			preparedStatement.setDate(3, (Date) sale.getData());
			preparedStatement.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao criar venda. Causado por: " + e.getMessage());
			return false;
		}
		System.out.println("Venda criado com sucesso!");
		return true;
	}

	public boolean delete(Sale sale) {

		try {
			String sql = "delete from venda where id_venda = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, sale.getId());
			statement.execute();

			int updateCount = statement.getUpdateCount();

			if (updateCount == 0) {
				System.out.println("Venda não encontrada no banco. Venda não deletado.");
				return false;
			} else {
				System.out.println("Venda deletada com sucesso!");
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Erro ao deletar uma venda. Causado por: " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	public Sale vendaPorId(Connection conn,int id_venda) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("select * from venda where id_venda = ?");
		ResultSet resultSet = statement.getResultSet();
		statement.setInt(1, id_venda);
		statement.execute();
		resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			int id = resultSet.getInt("id_venda");
			int idCliente = resultSet.getInt("id_cliente");
			ClientDAO clientDao = new ClientDAO(conn);
			Client client = clientDao.clientePorId(conn, idCliente);
			double price = resultSet.getDouble("valor");
			Date data = resultSet.getDate("data"); 
			Sale venda = new Sale(client,data);
			venda.setId(id);
			return venda;
		}
		return null;
	}
}
