package market.application;

import java.sql.Connection;
import java.sql.SQLException;

import market.connection.FactoryConnection;
import market.util.Menu;

public class Program {

	public static void main(String[] args) throws SQLException {
		FactoryConnection factoryConnection = new FactoryConnection();
		try (Connection conn = factoryConnection.openConnection();) {
			System.out.println("Conexão estabelecida!\n");
			try {
				Menu.menuPrincipal(conn);
				factoryConnection.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println("\nErro ao se conectar ao banco de dados. Causado por: " + e.getMessage());
				e.printStackTrace();
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("\nErro de autenticação: Senha incorreta!");
		}
	}

}
