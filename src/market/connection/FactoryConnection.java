package market.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {

	public FactoryConnection() {}
	
	public Connection openConnection() throws SQLException {
		System.out.println("Preparando para abrir conexão com o banco de dados!");
		System.out.print("Digite o nome do usuario: ");
		return DriverManager.getConnection("jdbc:postgresql://localhost/mercado?useTimezone=true&serverTimezone=UTC", 
				"postgres", "1234");
	}
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
		System.out.println("Conexão Encerrada!");
	}
	
}
