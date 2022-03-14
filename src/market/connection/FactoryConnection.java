package market.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class FactoryConnection {

	public FactoryConnection() {}
	
	public Connection openConnection() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Preparando para abrir conexão com o banco de dados!");
		System.out.print("Digite o nome do usuario: ");
		String usr = sc.nextLine();
		System.out.print("Digite a senha para "+usr+": ");
		String pwd = sc.nextLine();
		return DriverManager.getConnection("jdbc:postgresql://localhost/mercado?useTimezone=true&serverTimezone=UTC", 
				usr, pwd);
	}
	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
		System.out.println("Conexão Encerrada!");
	}
	
}
