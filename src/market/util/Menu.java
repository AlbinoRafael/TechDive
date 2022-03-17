package market.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import market.model.dao.ClientDAO;
import market.model.dao.ProductDAO;
import market.model.dao.SaleDAO;
import market.model.dao.SaleItemDAO;
import market.model.entities.Client;
import market.model.entities.Product;
import market.model.entities.Sale;
import market.model.entities.SaleItem;

public class Menu {
	
	public static void menuPrincipal(Connection conn) throws SQLException {
		boolean continua = true;
		do {
			System.out.println("\n\n");
			System.out.println("====================================================");
			System.out.println("=                   Menu Principal                 =");
			System.out.println("====================================================");
			System.out.println("=                                                  =");
			System.out.println("=                    1-Clientes                    =");
			System.out.println("=                    2-Produtos                    =");
			System.out.println("=                    3-Vendas                      =");
			System.out.println("=                                                  =");
			System.out.println("=                    0-Sair                        =");
			System.out.println("====================================================");
			System.out.print("Selecione uma opção: ");

			Scanner sc = new Scanner(System.in);
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				menuClientes(conn);
				;
				break;
			case 2:
				menuProdutos(conn);
				break;
			case 3:
				menuVendas(conn);
				break;
			case 0:
				continua = false;
				break;
			default:
				continua = true;
			}
		} while (continua);
	}

	public static void menuClientes(Connection conn) throws SQLException {
		boolean continua = true;
		do {
			System.out.println("\n");
			System.out.println("====================================================");
			System.out.println("=                  Menu de Clientes                =");
			System.out.println("====================================================");
			System.out.println("=                                                  =");
			System.out.println("=                 1-Criar novo cliente             =");
			System.out.println("=                 2-Listar clientes                =");
			System.out.println("=                 3-Deletar um cliente             =");
			System.out.println("=                                                  =");
			System.out.println("=                 0-Sair                           =");
			System.out.println("====================================================");
			System.out.print("Selecione uma opção: ");

			Scanner sc = new Scanner(System.in);
			int opcao = sc.nextInt();
			System.out.println();
			switch (opcao) {
			case 1:
				sc.nextLine();
				System.out.print("Digite o nome do cliente: ");
				String nome = sc.nextLine();
				System.out.print("Digite o cpf do cliente: ");
				String cpf = sc.nextLine();
				Client cliente = new Client(nome, cpf);
				ClientDAO clienteDao = new ClientDAO(conn);
				clienteDao.create(cliente);
				break;
			case 2:
				clienteDao = new ClientDAO(conn);
				System.out.println("==================================================================");
				System.out.println("=                         Lista de Clientes                      =");
				System.out.println("==================================================================");
				System.out.printf("%15s%27s%20s%n", "NOME", "ID", "CPF");
				System.out.println("------------------------------------------------------------------");
				clienteDao.list();
				break;
			case 3:
				clienteDao = new ClientDAO(conn);
				System.out.println("Selecione a seguir o ID do cliente: \n");
				clienteDao.list();
				System.out.print("\nDigite o ID do cliente a ser removido: ");
				try {
					int idCliente = sc.nextInt();
					clienteDao.delete(clienteDao.clientePorId(conn, idCliente));
				} catch (InputMismatchException e) {
					System.out.println("\nInsira apenas numeros!");
				} catch (NullPointerException e) {
					System.out.println("\nProduto não encontrado no banco. Produto não deletado.");
				}
				break;
			case 0:
				continua = false;
				break;
			default:
				continua = true;
			}
		} while (continua);

	}

	public static void menuProdutos(Connection conn) throws SQLException {
		boolean continua = true;
		do {
			System.out.println("\n\n");
			System.out.println("====================================================");
			System.out.println("=                  Menu de Produtos                =");
			System.out.println("====================================================");
			System.out.println("=                                                  =");
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
				sc.nextLine();
				System.out.print("Digite o nome do produto: ");
				String nome = sc.nextLine();
				System.out.print("Digite a descrição do produto: ");
				String descricao = sc.nextLine();
				Product product = new Product(nome, descricao);
				ProductDAO produtoDao = new ProductDAO(conn);
				produtoDao.create(product);
				break;
			case 2:
				produtoDao = new ProductDAO(conn);
				System.out.println("==================================================================");
				System.out.println("=                         Lista de Produtos                      =");
				System.out.println("==================================================================");
				System.out.printf("%10s%22s%20s%n", "NOME", "ID", "DESCRIÇÃO");
				System.out.println("------------------------------------------------------------------");
				produtoDao.list();
				break;
			case 3:
				produtoDao = new ProductDAO(conn);
				System.out.println("Selecione a seguir o ID do produto: \n");
				produtoDao.list();
				System.out.print("\nDigite o ID do produto a ser removido: ");
				try {
					int idProduto = sc.nextInt();
					produtoDao.delete(produtoDao.produtoPorId(conn, idProduto));
				} catch (InputMismatchException e) {
					System.out.println("\nInsira apenas numeros!");
				} catch (NullPointerException e) {
					System.out.println("\nProduto não encontrado no banco. Produto não deletado.");
				}
				break;
			case 0:
				continua = false;
				break;
			default:
				continua = true;
			}
		} while (continua);
	}

	public static void menuVendas(Connection conn) throws SQLException {
		boolean continua = true;
		do {
			System.out.println("\n\n");
			System.out.println("====================================================");
			System.out.println("=                  Menu de Vendas                  =");
			System.out.println("====================================================");
			System.out.println("=                                                  =");
			System.out.println("=                1-Criar nova venda                =");
			System.out.println("=                2-Listar vendas                   =");
			System.out.println("=                3-Listar vendas com clientes      =");
			System.out.println("=                4-Deletar uma venda               =");
			System.out.println("=                5-Itens de uma venda              =");
			System.out.println("=                                                  =");
			System.out.println("=                0-Sair                            =");
			System.out.println("====================================================");
			System.out.print("Selecione uma opção: ");

			Scanner sc = new Scanner(System.in);
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				sc.nextLine();
				ClientDAO clientDao = new ClientDAO(conn);
				System.out.println("Selecione a seguir o ID do cliente: ");
				clientDao.list();
				int idClient = sc.nextInt();
				Client client = clientDao.clientePorId(conn, idClient);
				Date data = Date.valueOf(LocalDate.now());
				Sale venda = new Sale(client, data);
				SaleDAO vendaDao = new SaleDAO(conn);
				vendaDao.create(venda);
				break;
			case 2:
				vendaDao = new SaleDAO(conn);
				System.out.println("===============================================================================");
				System.out.println("=                               Lista de Vendas                               =");
				System.out.println("===============================================================================");
				System.out.printf("%10s%22s%20s%27s%n", "NOME", "ID", "TOTAL", "DATA(ano-mes-dia)");
				System.out.println("-------------------------------------------------------------------------------");
				vendaDao.list();
				break;
			case 3:
				vendaDao = new SaleDAO(conn);
				System.out.println("============================================================================================");
				System.out.println("=                               Lista de Vendas com Clientes                               =");
				System.out.println("============================================================================================");
				System.out.printf("%10s%20s%27s%20s%20s%n", "NOME","TOTAL", "DATA(ano-mes-dia)","CLIENTE","CPF");
				System.out.println("--------------------------------------------------------------------------------------------");
				vendaDao.listVendaECliente();
				break;
			case 4:
				vendaDao = new SaleDAO(conn);
				System.out.println("Selecione a seguir o ID da venda: \n");
				vendaDao.list();
				System.out.print("\nDigite o ID da venda a ser removida: ");
				try {
					int idVenda = sc.nextInt();
					vendaDao.delete(vendaDao.vendaPorId(conn, idVenda));
				} catch (InputMismatchException e) {
					System.out.println("\nInsira apenas numeros!");
				} catch (NullPointerException e) {
					System.out.println("\nVenda não encontrada no banco. Venda não deletada.");
				}
				break;
			case 5:
				menuItensVenda(conn);
				break;
			case 0:
				continua = false;
				break;
			default:
				continua = true;
			}
		} while (continua);
	}

	public static void menuItensVenda(Connection conn) throws SQLException {
		Locale.setDefault(Locale.US);
		boolean continua = true;
		do {
			System.out.println("\n\n");
			System.out.println("===========================================================");
			System.out.println("=                  Menu de Itens de Vendas                =");
			System.out.println("===========================================================");
			System.out.println("=                                                         =");
			System.out.println("=                1-Criar novo item de uma venda           =");
			System.out.println("=                2-Listar itens de uma venda              =");
			System.out.println("=                3-Deletar itens uma venda                =");
			System.out.println("=                                                         =");
			System.out.println("=                0-Sair                                   =");
			System.out.println("===========================================================");
			System.out.print("Selecione uma opção: ");

			Scanner sc = new Scanner(System.in);
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				sc.nextLine();
				SaleDAO saleDao = new SaleDAO(conn);
				System.out.println("Selecione a seguir o ID da venda: \n");
				saleDao.list();
				System.out.print("\nDigite o id da venda: ");
				int idVenda = sc.nextInt();
				Sale venda = saleDao.vendaPorId(conn, idVenda);
				ProductDAO prodDao = new ProductDAO(conn);
				System.out.println("Selecione a seguir o ID do produto: \n");
				prodDao.list();
				System.out.print("\nDigite o id do produto: ");
				int idProd = sc.nextInt();
				Product prod = prodDao.produtoPorId(conn, idProd);
				System.out.print("Digite a quantidade: ");
				int quantidade = sc.nextInt();
				System.out.print("Digite o valor unitário: ");
				sc.nextLine();
				double preco_un = Double.parseDouble(sc.nextLine());
				SaleItem itemVenda = new SaleItem(venda, prod, quantidade, preco_un);
				SaleItemDAO itemVendaDao = new SaleItemDAO(conn);
				itemVendaDao.create(itemVenda);
				break;
			case 2:
				sc.nextLine();
				SaleDAO vendaDao = new SaleDAO(conn);
				System.out.println("Selecione o ID da venda: \n");
				vendaDao.list();
				System.out.print("\nDigite o id da venda: ");
				idVenda = sc.nextInt();
				venda = vendaDao.vendaPorId(conn, idVenda);
				itemVendaDao = new SaleItemDAO(conn);
				System.out.println("==============================================================================================================");
				System.out.println("=                                               Lista de itens Venda                                         =");
				System.out.println("==============================================================================================================");
				System.out.printf("%10s%12s%25s%35s%15s%12s%n", "ID", "NOME","DESCRIÇÃO","QUANTIDADE", "VALOR UNT", "SUBTOTAL");
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				itemVendaDao.listaPorVenda(venda);
				break;
			case 3:
				sc.nextLine();
				itemVendaDao = new SaleItemDAO(conn);
				vendaDao = new SaleDAO(conn);
				System.out.println("Selecione o ID da venda: \n");
				vendaDao.list();
				System.out.print("\nDigite o id da venda: ");
				idVenda = sc.nextInt();
				venda = vendaDao.vendaPorId(conn, idVenda);
				itemVendaDao = new SaleItemDAO(conn);
				System.out.println("Selecione a seguir o ID do item venda: \n");
				System.out.println("==============================================================================================================");
				System.out.println("=                                               Lista de itens Venda                                         =");
				System.out.println("==============================================================================================================");
				System.out.printf("%10s%12s%25s%35s%15s%12s%n", "ID", "NOME","DESCRIÇÃO","QUANTIDADE", "VALOR UNT", "SUBTOTAL");
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				itemVendaDao.listaPorVenda(venda);
				System.out.print("\nDigite o ID do item venda a ser removido: ");
				try {
					int idItemVenda = sc.nextInt();
					itemVendaDao.delete(itemVendaDao.itemVendaPorId(conn, idItemVenda));
				} catch (InputMismatchException e) {
					System.out.println("\nInsira apenas numeros!");
				} catch (NullPointerException e) {
					System.out.println("\n item Venda não encontrado no banco.item Venda não deletado.");
				}
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
