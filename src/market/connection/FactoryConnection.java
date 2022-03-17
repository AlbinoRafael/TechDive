package market.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class FactoryConnection {

	private String jdbcUrl = "jdbc:postgresql://localhost/mercado?useTimezone=true&serverTimezone=UTC";

	private String user;

	private String password;

	private DataSource dataSource;

	public FactoryConnection() {
		Scanner sc = new Scanner(System.in);
		ComboPooledDataSource comboPooled = new ComboPooledDataSource();
		comboPooled.setJdbcUrl(jdbcUrl);
		System.out.print("Digite o nome do usuario: ");
		this.user = sc.nextLine();
		comboPooled.setUser(user);
		System.out.print("Digite a senha para " + user + ": ");
		this.password = sc.nextLine();
		comboPooled.setPassword(password);

		this.dataSource = comboPooled;
	}

	public Connection openConnection() throws SQLException {
		System.out.println("Preparando para abrir conexão com o banco de dados!");
		return this.dataSource.getConnection();
	}

	public void closeConnection(Connection conn) throws SQLException {
		conn.close();
		System.out.println("Conexão Encerrada!");
	}

}
