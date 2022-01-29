package bancotechdive.banco;

import bancotechdive.banco.conta.Conta;
import bancotechdive.banco.conta.ContaCorrente;
import bancotechdive.banco.conta.ContaInvestimento;
import bancotechdive.banco.conta.ContaPoupanca;
import bancotechdive.banco.servico.Relatorio;
import bancotechdive.banco.utils.MostraListas;
import bancotechdive.banco.utils.MsgPadrao;

import java.text.ParseException;
import java.util.*;

public class Banco {

    public Banco() {
    }

    private static List<Agencia> agencias = new ArrayList<>();
    private static List<Conta> contas = new ArrayList<>();

    static {
        adicionaAgencia(new Agencia("001", "Florianópolis"));
        adicionaAgencia(new Agencia("002", "São José"));
        adicionaConta(new ContaCorrente("Joao Pedro", "238472837284", 1500));
        adicionaConta(new ContaInvestimento("Maria José", "12312412", 1200));
        adicionaConta(new ContaCorrente("Antonio Souza", "6435453234", 4200));
        adicionaConta(new ContaPoupanca("Ana Maria da Silva", "5634563456234", 2400));
        adicionaConta(new ContaCorrente("Marcos Silva", "238472837284", 1300));
        adicionaConta(new ContaCorrente("Joana Soares", "12312412", 1800));
        adicionaConta(new ContaPoupanca("Juarez Cardoso", "6435453234", 3500));
        adicionaConta(new ContaInvestimento("Maria Antonia dos Santos", "5634563456234", 2900));
    }

    public static void main(String[] args) throws InterruptedException, ParseException {
        programa();
    }

    public static void programa() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do {
            System.out.print(menu(1));
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    //cria uma nova conta(Conta corrente, poupança ou investimento)
                    criaConta();
                    break;
                case 2:
                    //atualiza os dados da conta
                    atualizaConta((Conta) MostraListas.mostraItens(contas));
                    break;
                case 3:
                    //faz transação do tipo Saque
                    Conta conta = (Conta) MostraListas.mostraItens(contas);
                    if (conta != null) {
                        if(conta.getSaldo()>0) {
                            System.out.print("\nDigite o valor do saque: R$");
                            conta.saque(sc.nextDouble());
                        }else{
                            MsgPadrao.mensagem("Você não possui saldo para realizar esta operação");
                        }
                    } else {
                        MsgPadrao.mensagem("Opção inválida!");
                    }
                    break;
                case 4:
                    //faz transação do tipo Deposito
                    conta = (Conta) MostraListas.mostraItens(contas);
                    if (conta != null) {
                        System.out.print("Digite o valor do depósito: R$");
                        double valorDeposito = sc.nextDouble();
                        conta.deposito(valorDeposito);
                    } else {
                        MsgPadrao.mensagem("Opção inválida!");
                    }
                    break;
                case 5:
                    //faz transação do tipo Transferencia
                    System.out.println("\nSelecione a conta de origem: ");
                    conta = (Conta) MostraListas.mostraItens(contas);
                    if (conta != null) {
                        System.out.print("\nDigite o valor da transferência: R$");
                        double valorTransferencia = sc.nextDouble();
                        System.out.println("\nSelecione a conta de destino: ");
                        Conta contaAlvo = (Conta) MostraListas.mostraItens(contas);
                        if (contaAlvo != null) {
                            conta.transferir(contaAlvo, valorTransferencia);
                        } else {
                            MsgPadrao.mensagem("Opção inválida!");
                        }
                    } else {
                        MsgPadrao.mensagem("Opção inválida!");
                    }
                    break;
                case 6:
                    //mostra o saldo de uma conta especifica
                    conta = (Conta) MostraListas.mostraItens(contas);
                    if (conta != null) {
                        if (conta instanceof ContaCorrente) {
                            ContaCorrente cc = (ContaCorrente) conta;
                            if (cc.getSaldo() >= 0) {
                                MsgPadrao.mensagem("-------SALDO------\n\nNome: " + conta.getNome() + "\nSaldo disponivel: R$ " + conta.getSaldo());
                            } else {
                                MsgPadrao.mensagem("-------SALDO------\n\nNome: " + conta.getNome() + "\nSaldo disponivel: R$ " +
                                        conta.getSaldo() + "\nData limite: " + cc.periodoFicarNegativado());
                            }
                        } else if (conta instanceof ContaInvestimento) {
                            ContaInvestimento ci = (ContaInvestimento) conta;
                            if (ci.getSaldo() >= 0) {
                                MsgPadrao.mensagem("-------SALDO------\n\nNome: " + ci.getNome() +
                                        "\nSaldo disponivel: R$ " + ci.getSaldo() +
                                        "\nTotal investido: RS " + ci.getTotalInvestido() +
                                        "\nSaldo total: R$ " + ci.getSaldoTotal());
                            }
                        } else {
                            MsgPadrao.mensagem("-------SALDO------\n\nNome: " + conta.getNome() + "\nSaldo disponivel: R$ " + conta.getSaldo());
                        }
                    } else {
                        MsgPadrao.mensagem("Opção inválida!");
                    }
                    break;
                case 7:
                    //mostra o extrato de uma conta especifica
                    conta = (Conta) MostraListas.mostraItens(contas);
                    if (conta != null) {
                        if (conta.getExtrato() != null) {
                            MsgPadrao.mensagem(conta.extrato());
                        } else {
                            MsgPadrao.mensagem("Você ainda não realizou nenhuma operação!");
                        }
                    } else {
                        MsgPadrao.mensagem("Opção inválida!");
                    }
                    break;
                case 8:
                    //mostra o histórico de todas as transações
                    MsgPadrao.mensagem(historico());
                    break;
                case 9:
                    //faz simulação de rendimentos para documentos.contas do tipo Poupança
                    ContaPoupanca cp = (ContaPoupanca) MostraListas.contasTotal(MostraListas.contasPoupanca(contas));

                    if (cp instanceof ContaPoupanca) {
                        if (cp.getSaldo() > 0) {
                            System.out.print("Informe a quantidade de tempo(em meses): ");
                            int meses = sc.nextInt();
                            System.out.print("Informe a porcentagem anual(Ex: 1.5): ");
                            double rendimentoAnual = sc.nextDouble();
                            MsgPadrao.mensagem("--------Simulação de Rendimentos -------\n" +
                                    "\nValor: R$" + cp.getSaldo() +
                                    "\nPeríodo(meses): " + meses +
                                    "\nPorcentagem anual: " + rendimentoAnual + "%" + "\nValor final: R$" +
                                    String.format("%.2f", cp.simulaRendimentos(cp.getSaldo(), meses, rendimentoAnual)) + "\n");
                        } else {
                            MsgPadrao.mensagem("Você não possui fundos para fazer a simulação!");
                        }
                    } else {
                        MsgPadrao.mensagem("Sua conta não possui suporte à este serviço!");
                    }
                    break;
                case 10:
                    conta = (ContaInvestimento) MostraListas.contasTotal(MostraListas.contasInvestimento(contas));
                    if (conta instanceof ContaInvestimento) {
                        //entra nas opções de investimentos
                        System.out.print(menu(4));//opcoes de investimentos
                        int op = sc.nextInt();
                        System.out.print(menu(5));//menu para investimentos
                        op = sc.nextInt();
                        switch (op) {
                            //opcao para fazer simulacao do investimento
                            case 1:
                                ContaInvestimento ci = (ContaInvestimento) conta;
                                System.out.print("Informe o valor de investimento: R$");
                                double simulaInvestimento = sc.nextDouble();
                                double simulaRendimentoAnual = 0;
                                if (op == 1) {
                                    simulaRendimentoAnual = 1.2;
                                    ci.simulaRendimentos(simulaInvestimento, 12, simulaRendimentoAnual);//taxa 120% valor do CDI
                                } else if (op == 2) {
                                    simulaRendimentoAnual = 2;
                                    ci.simulaRendimentos(simulaInvestimento, 12, simulaRendimentoAnual);//taxa 2% ao ano
                                }
                                MsgPadrao.mensagem("\n========================================\n"+
                                                          "--------Simulação de Rendimentos -------" +
                                                        "\n========================================\n"+
                                        "\nValor: R$" + simulaInvestimento +
                                        "\nPeríodo(meses): " + 12 +
                                        "\nPorcentagem anual: " + simulaRendimentoAnual + "%" + "\nValor final: R$" +
                                        String.format("%.2f", ci.simulaRendimentos(simulaInvestimento, 12, simulaRendimentoAnual)) + "\n");
                                break;
                            case 2:
                                ci = (ContaInvestimento) conta;
                                if (ci.getSaldo() > 0) {
                                    System.out.print("Informe o valor de investimento: ");
                                    double investimento = sc.nextDouble();
                                    double rendimentoAnual = 0;
                                    if (op == 1) {
                                        rendimentoAnual = 1.2;
                                        ci.investir("CDB", investimento, rendimentoAnual);//taxa 120% valor do CDI
                                    } else if (op == 2) {
                                        rendimentoAnual = 2;
                                        ci.investir("Tesouro Direto", investimento, rendimentoAnual);//taxa 2% ao ano
                                    }
                                    MsgPadrao.mensagem("\n========================================\n"+
                                                              "-------------- Investimentos -----------" +
                                                            "\n========================================\n"+
                                            "\nValor: R$" + investimento +
                                            "\nPeríodo(meses): " + 12 +
                                            "\nPorcentagem anual: " + rendimentoAnual + "%" + "\nValor final: R$" +
                                            String.format("%.2f", ci.getTotalInvestido()) + "\n");
                                } else {
                                    MsgPadrao.mensagem("Você não possui fundos para realizar esta operação!");
                                }
                                break;
                            case 0:
                                break;
                        }
                    }
                    break;
                case 11:
                    int op;
                    do {
                        System.out.print(menu(6));
                        op = sc.nextInt();
                        switch (op) {
                            case 1:
                                System.out.print(menu(7));
                                int op1 = sc.nextInt();
                                switch (op1) {
                                    case 1:
                                        MsgPadrao.mensagem("\n========================================\n"+
                                                                  "-------- Lista de Contas Corrente ------" +
                                                                "\n========================================\n\n"+
                                                Relatorio.listarContas("ContaCorrente", contas));
                                        break;
                                    case 2:
                                        MsgPadrao.mensagem("\n========================================\n"+
                                                                  "------- Lista de Contas Poupança -------" +
                                                                "\n========================================\n"+
                                                Relatorio.listarContas("ContaPoupanca", contas));
                                        break;
                                    case 3:
                                        MsgPadrao.mensagem("\n========================================\n"+
                                                                  "----- Lista de Contas Investimento -----" +
                                                                "\n========================================\n"+
                                                Relatorio.listarContas("ContaInvestimento", contas));
                                        break;
                                    case 4:
                                        MsgPadrao.mensagem(Relatorio.listarContasSaldoNegativo(contas));
                                        break;
                                    case 5:
                                        MsgPadrao.mensagem(Relatorio.listarTodasContas(contas));
                                        break;
                                    case 0:
                                        break;
                                }
                                break;
                            case 2:
                                ContaInvestimento ci = (ContaInvestimento) MostraListas.contasTotal(MostraListas.contasInvestimento(contas));
                                MsgPadrao.mensagem(Relatorio.totalValorInvestido(Relatorio.setaValorContaInvestimento(ci, contas)));
                                break;
                            case 3:
                                Conta conta1 = (Conta) MostraListas.mostraItens(contas);
                                MsgPadrao.mensagem(Relatorio.todasTransacoesUnicoCliente(conta1));
                                break;
                            case 0:
                                break;
                        }
                    } while (op != 0);
                    break;
                case 0:
                    break;
                default:
                    MsgPadrao.mensagem("Opção inválida!");
            }
        } while (opcao != 0);
        sc.close();
    }

    public static void criaConta() {
        Scanner sc = new Scanner(System.in);
        System.out.print(menu(2));
        int opcao = sc.nextInt();
        try {
            switch (opcao) {
                case 1:
                    ContaCorrente cc = new ContaCorrente();
                    setaValoresConta(cc);
                    adicionaConta(cc);
                    break;
                case 2:
                    ContaPoupanca cp = new ContaPoupanca();
                    setaValoresConta(cp);
                    contas.add(cp);
                    break;
                case 3:
                    ContaInvestimento ci = new ContaInvestimento();
                    setaValoresConta(ci);
                    contas.add(ci);
                    break;
                case 0:
                    break;
                default:
                    MsgPadrao.mensagem("Opção inválida!");
            }
        } catch (InputMismatchException e) {
            MsgPadrao.mensagem("Digite apenas números!");
        }
    }

    public static boolean validaCPF(String cpf) {
        boolean isValido = false;
        if (cpf.length() == 11 && cpf.matches("[+-]?\\d*(\\.\\d+)?") && !cpf.contains("^[a-zA-Z]") &&
                !cpf.equals(null) && !cpf.isBlank() && !cpf.contains(" ")) {
            int contador = 1;
            char[] cpfs = cpf.toCharArray();
            for (int i = 0; i < cpfs.length - 1; i++) {
                if (cpfs[i] == cpfs[i + 1]) {
                    contador++;
                }
            }
            if (contador == cpf.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

    public static void setaValoresConta(Conta conta){

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite seu CPF: ");
        String cpf = sc.nextLine();
        if (validaCPF(cpf) == true) {
            System.out.print("Digite seu nome: ");
            conta.setNome(sc.nextLine());
            conta.setCpf(cpf);
            System.out.println("\nSelecione a agencia:");
            conta.setAgencia((Agencia) MostraListas.mostraItens(agencias));
            System.out.print("Digite sua renda mensal: R$ ");
            conta.setRendaMensal(sc.nextDouble());
        } else {
            MsgPadrao.mensagem("CPF inválido!");
        }
    }

    public static void atualizaConta(Conta conta) {
        Scanner sc = new Scanner(System.in);
        if (conta != null) {
            System.out.print(menu(3));
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nome atual: " + conta.getNome() +
                            "\nDigite o novo nome: ");
                    String novoNome = sc.nextLine();
                    conta.setNome(novoNome);
                    break;
                case 2:
                    System.out.println("Agência atual: " + conta.getAgencia() +
                            "\nEscolha a nova agência: ");
                    conta.setAgencia((Agencia) MostraListas.mostraItens(agencias));
                    break;
                case 3:
                    System.out.print("Renda mensal atual: R$ " + conta.getRendaMensal() +
                            "\nDigite o novo valor: R$");
                    conta.setRendaMensal(sc.nextDouble());
                    break;
                case 0:
                    break;
                default:
                    MsgPadrao.mensagem("Opção inválida!");
            }
        } else {
            MsgPadrao.mensagem("Opção inválida!");
        }
    }

    public static String historico() {
        String historico = "\n--------Histórico de Transações--------\n";
        for (int i = 0; i < contas.size(); i++) {
            if (!contas.get(i).getTransacoes().isEmpty()) {
                for (int j = 0; j < contas.get(i).getTransacoes().size(); j++) {
                    historico += contas.get(i).getTransacoes().get(j).toString();
                }
            }
        }
        if (historico.length() == 41) {
            historico = "Sem histórico de transações!";
        }
        return historico;
    }

    public static String menu(int opMenu) {
        String menuDeOpcoes = "";
        switch (opMenu) {
            case 1:
                menuDeOpcoes = "\n=======================================\n" +
                        "----------- Banco TechDive ------------" +
                        "\n=======================================\n\n" +
                        "1 -  Criar conta\n" +
                        "2 -  Atualizar conta\n" +
                        "3 -  Saque\n" +
                        "4 -  Depósito\n" +
                        "5 -  Transferência\n" +
                        "6 -  Saldo\n" +
                        "7 -  Extrato\n" +
                        "8 -  Histórico\n" +
                        "9 -  Simular rendimentos\n" +
                        "10 - Investimentos\n" +
                        "11 - Relatórios\n\n" +
                        "0 -  Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";

                break;
            case 2:
                menuDeOpcoes = "\n=======================================\n" +
                        "----------- Tipo da Conta -------------" +
                        "\n=======================================\n\n" +
                        "1 - Conta corrente\n" +
                        "2 - Conta Poupança\n" +
                        "3 - Conta Investimento\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            case 3:
                menuDeOpcoes = "\n=======================================\n" +
                        "----------- Atualiza conta ------------" +
                        "\n=======================================\n\n" +
                        "1 - nome\n" +
                        "2 - Agência\n" +
                        "3 - Renda mensal\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            case 4:
                menuDeOpcoes = "\n=======================================\n" +
                        "-------- Menu de Investimento ---------" +
                        "\n=======================================\n\n" +
                        "1 - Simulação\n" +
                        "2 - Investir\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            case 5:
                menuDeOpcoes = "\n=======================================\n" +
                        "-------- Opções de Investimento -------" +
                        "\n=======================================\n\n" +
                        "1 - CDB\n" +
                        "2 - Tesouro direto\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            case 6:
                menuDeOpcoes = "\n=======================================\n" +
                        "--------- Opções de Relatórios --------" +
                        "\n=======================================\n\n" +
                        "1 - Listar documentos.contas\n" +
                        "2 - Valor total investido\n" +
                        "3 - Todas transações(cliente único)\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            case 7:
                menuDeOpcoes = "\n=======================================\n" +
                        "----------- Listar documentos.contas -------------" +
                        "\n=======================================\n" +
                        "1 - documentos.contas corrente\n" +
                        "2 - documentos.contas poupança\n" +
                        "3 - documentos.contas investimento\n\n" +
                        "4 - Listar documentos.contas com saldo negativo\n" +
                        "5 - Listar todas as documentos.contas\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            default:
                System.out.println("Opção inválida");
        }
        return menuDeOpcoes;
    }
    private static void adicionaConta(Conta conta){
        contas.add(conta);
        conta.gravaConta();
    }
    private static void adicionaAgencia(Agencia agencia){
        agencias.add(agencia);
        agencia.gravaAgencia();
    }
}
