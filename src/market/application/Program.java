package market.application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import market.connection.FactoryConnection;
import market.model.dao.ClientDAO;
import market.model.dao.ProductDAO;
import market.model.dao.SaleDAO;
import market.model.dao.SaleItemDAO;
import market.model.entities.SaleItem;

public class Program {

	public static void main(String[] args) throws SQLException {
		FactoryConnection factoryConnection = new FactoryConnection();
		try (Connection conn = factoryConnection.openConnection();) {
			System.out.println("Abriu conexão!");
			try {
				conn.setAutoCommit(false);

				SaleItemDAO saleItemDao = new SaleItemDAO(conn);
				saleItemDao.list();

				factoryConnection.closeConnection(conn);
			} catch (SQLException e) {
				System.out.println("Erro ao se conectar ao banco de dados. Causado por: " + e.getMessage());
				e.printStackTrace();
				conn.rollback();
			}
		} catch (SQLException e) {
			System.out.println("Erro de autenticação: Senha incorreta!");
		}
	}

	public static void menu(Connection conn) throws SQLException {
		boolean continua = false;
		do {
			System.out.println("\n\n");
			System.out.println("====================================================");
			System.out.println("=                  Menu de Produtos                =");
			System.out.println("====================================================");
			System.out.println("=                1-Criar novo produto              =");
			System.out.println("=                2-Listar produtos                 =");
			System.out.println("=                3-Deletar um produto              =");
			System.out.println("=                                                  =");
			System.out.println("=                0-Sair                            =");
			System.out.println("====================================================");
			System.out.print("Selecione uma opção: ");

			Scanner sc = new Scanner(System.in);
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
//				createProduct(conn);
				break;
			case 2:
//				listProducts(conn);
				break;
			case 3:
//				deleteProduct(conn);
				break;
			case 0:
				continua = false;
				break;
			default:
				continua = true;
			}
		} while (continua);
	}
}
