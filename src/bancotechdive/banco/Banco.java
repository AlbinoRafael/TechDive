package bancotechdive.banco;

import bancotechdive.banco.conta.Conta;
import bancotechdive.banco.conta.ContaCorrente;
import bancotechdive.banco.conta.ContaInvestimento;
import bancotechdive.banco.conta.ContaPoupanca;
import bancotechdive.banco.servico.Relatorio;
import bancotechdive.banco.servico.Transacao;
import bancotechdive.banco.utils.MostraListas;
import bancotechdive.banco.utils.MsgPadrao;

import java.io.*;
import java.util.*;

public class Banco {

    public Banco() {
    }

    private static List<Agencia> agencias = new ArrayList<>();
    private static List<Conta> contas = new ArrayList<>();

    static {
        //adicionaAgencia(new Agencia("001", "Florianópolis"));
        //adicionaAgencia(new Agencia("002", "São José"));
        carregaContas();
        carregaAgencias();
        /*adicionaConta(new ContaCorrente("Joao Pedro", "238472837284", 1500));
        adicionaConta(new ContaInvestimento("Maria José", "12312412", 1200));
        adicionaConta(new ContaCorrente("Antonio Souza", "6435453234", 4200));
        adicionaConta(new ContaPoupanca("Ana Maria da Silva", "5634563456234", 2400));
        adicionaConta(new ContaCorrente("Marcos Silva", "238472837284", 1300));
        adicionaConta(new ContaCorrente("Joana Soares", "12312412", 1800));
        adicionaConta(new ContaPoupanca("Juarez Cardoso", "6435453234", 3500));
        adicionaConta(new ContaInvestimento("Maria Antonia dos Santos", "5634563456234", 2900));*/

        try {
            verificaArquivos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        programa();
    }

    public static void programa() {
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
                    regravaInformacoes();
                    break;
                case 3:
                    //faz transação do tipo Saque
                    Conta conta = (Conta) MostraListas.mostraItens(contas);
                    if (conta != null) {
                        if (conta.getSaldo() > 0) {
                            System.out.print("\nDigite o valor do saque: R$");
                            double valor = sc.nextDouble();
                            conta.saque(valor);
                            conta.gravaExtrato();
                            gravaHistorico("Saque realizado! Valor: "+valor+" Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                            regravaInformacoes();
                        } else {
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
                        conta.gravaExtrato();
                        gravaHistorico("Depósito realizado! Valor: "+valorDeposito +" Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                        regravaInformacoes();
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
                            conta.gravaExtrato();
                            gravaHistorico("Transferência realizada! Valor: "+valorTransferencia+" Conta origem: "+conta.getNome()+", cpf origem: "+conta.getCpf()+", Conta destino: "+contaAlvo.getNome()+", cpf destino: "+contaAlvo.getCpf()+" - "+conta.mostraData());
                            regravaInformacoes();
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
                                gravaHistorico("Consulta de saldo! Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                            } else {
                                MsgPadrao.mensagem("-------SALDO------\n\nNome: " + conta.getNome() + "\nSaldo disponivel: R$ " +
                                        conta.getSaldo() + "\nData limite: " + cc.periodoFicarNegativado());
                                gravaHistorico("Consulta de saldo! Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                            }
                        } else if (conta instanceof ContaInvestimento) {
                            ContaInvestimento ci = (ContaInvestimento) conta;
                            if (ci.getSaldo() >= 0) {
                                MsgPadrao.mensagem("-------SALDO------\n\nNome: " + ci.getNome() +
                                        "\nSaldo disponivel: R$ " + ci.getSaldo() +
                                        "\nTotal investido: RS " + ci.getTotalInvestido() +
                                        "\nSaldo total: R$ " + ci.getSaldoTotal());
                                gravaHistorico("Consulta de saldo! Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                            }
                        } else {
                            MsgPadrao.mensagem("-------SALDO------\n\nNome: " + conta.getNome() + "\nSaldo disponivel: R$ " + conta.getSaldo());
                            gravaHistorico("Consulta de saldo! Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
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
                            gravaHistorico("Consulta de extrato! Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                        } else {
                            MsgPadrao.mensagem("Você ainda não realizou nenhuma operação!");
                            gravaHistorico("Consulta de extrato! Nome: "+conta.getNome()+", cpf: "+conta.getCpf()+" - "+conta.mostraData());
                        }
                    } else {
                        MsgPadrao.mensagem("Opção inválida!");
                    }
                    break;
                case 8:
                    //mostra o histórico de todas as transações
                    MsgPadrao.mensagem(mostraHistorico());
                    break;
                case 9:
                    //faz simulação de rendimentos para contas do tipo Poupança
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
                            gravaHistorico("Simulação de rendimentos(Conta Poupança)! Nome: "+cp.getNome()+", cpf: "+cp.getCpf()+" - "+cp.mostraData());
                        } else {
                            MsgPadrao.mensagem("Você não possui fundos para fazer a simulação!");
                            gravaHistorico("Simulação de rendimentos(Conta Poupança)! Nome: "+cp.getNome()+", cpf: "+cp.getCpf()+" - "+cp.mostraData());
                        }
                    } else {
                        MsgPadrao.mensagem("Sua conta não possui suporte à este serviço!");
                    }
                    break;
                case 10:
                    conta = MostraListas.contasTotal(MostraListas.contasInvestimento(contas));
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
                                MsgPadrao.mensagem("\n========================================\n" +
                                        "--------Simulação de Rendimentos -------" +
                                        "\n========================================\n" +
                                        "\nValor: R$" + simulaInvestimento +
                                        "\nPeríodo(meses): " + 12 +
                                        "\nPorcentagem anual: " + simulaRendimentoAnual + "%" + "\nValor final: R$" +
                                        String.format("%.2f", ci.simulaRendimentos(simulaInvestimento, 12, simulaRendimentoAnual)) + "\n");
                                gravaHistorico("Simulação de rendimentos(Conta Investimento)! Nome: "+ci.getNome()+", cpf: "+ci.getCpf()+" - "+ci.mostraData());
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
                                    MsgPadrao.mensagem("\n========================================\n" +
                                            "-------------- Investimentos -----------" +
                                            "\n========================================\n" +
                                            "\nValor: R$" + investimento +
                                            "\nPeríodo(meses): " + 12 +
                                            "\nPorcentagem anual: " + rendimentoAnual + "%" + "\nValor final: R$" +
                                            String.format("%.2f", ci.getTotalInvestido()) + "\n");
                                    gravaHistorico("Investimento(Conta Investimento)!Valor: "+investimento+" Nome: "+ci.getNome()+", cpf: "+ci.getCpf()+" - "+ci.mostraData());
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
                                        MsgPadrao.mensagem("\n========================================\n" +
                                                "-------- Lista de Contas Corrente ------" +
                                                "\n========================================\n\n" +
                                                Relatorio.listarContas("ContaCorrente", contas));
                                        break;
                                    case 2:
                                        MsgPadrao.mensagem("\n========================================\n" +
                                                "------- Lista de Contas Poupança -------" +
                                                "\n========================================\n" +
                                                Relatorio.listarContas("ContaPoupanca", contas));
                                        break;
                                    case 3:
                                        MsgPadrao.mensagem("\n========================================\n" +
                                                "----- Lista de Contas Investimento -----" +
                                                "\n========================================\n" +
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
                    cc.setTipo("CC");
                    adicionaConta(cc);
                    break;
                case 2:
                    ContaPoupanca cp = new ContaPoupanca();
                    setaValoresConta(cp);
                    cp.setTipo("CP");
                    adicionaConta(cp);
                    break;
                case 3:
                    ContaInvestimento ci = new ContaInvestimento();
                    setaValoresConta(ci);
                    ci.setTipo("CI");
                    adicionaConta(ci);
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

    public static void setaValoresConta(Conta conta) {

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
                    File file = new File("documentos/transacoes/" + conta.getNome() + ".txt");
                    System.out.print("Nome atual: " + conta.getNome() +
                            "\nDigite o novo nome: ");
                    String novoNome = sc.nextLine();
                    for (Conta c : contas) {
                        for (Transacao t : c.getTransacoes()) {
                            if (t.getTipo().equals("Transferência")) {
                                if (t.getConta().getNome().equals(conta.getNome())) {
                                    if (file.exists()) {
                                        file.renameTo(new File("documentos/transacoes/" + novoNome + ".txt"));
                                    }
                                    if (!conta.getNome().equals(novoNome)) {
                                        gravaHistorico("Nome atualizado! De: " + conta.getNome() + ", Para: " + novoNome + " - " + c.mostraData());
                                        t.getConta().setNome(novoNome);
                                        c.regravaTransacoes();
                                        try {
                                            Conta.verificaArquivosExtrato();
                                            Conta.regravaExtrato();
                                        }catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    } else {
                                        c.regravaTransacoes();
                                        try {
                                            Conta.verificaArquivosExtrato();
                                            Conta.regravaExtrato();
                                        }catch(Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                if (t.getContaAlvo().getNome().equals(c.getNome())) {
                                    if (file.exists()) {
                                        file.renameTo(new File("documentos/transacoes/" + novoNome + ".txt"));
                                    }
                                    gravaHistorico("Nome atualizado! De: " + conta.getNome() + ", Para: " + novoNome + " - " + c.mostraData());
                                    t.getConta().setNome(novoNome);
                                    c.regravaTransacoes();
                                    try {
                                        Conta.verificaArquivosExtrato();
                                        Conta.regravaExtrato();
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                                if(t.getContaAlvo().getNome().equals(conta.getNome())){
                                    if (file.exists()) {
                                        file.renameTo(new File("documentos/transacoes/" + novoNome + ".txt"));
                                    }
                                    gravaHistorico("Nome atualizado! De: " + conta.getNome() + ", Para: " + novoNome + " - " + c.mostraData());
                                    t.getConta().setNome(novoNome);
                                    c.regravaTransacoes();
                                    try {
                                        Conta.verificaArquivosExtrato();
                                        Conta.regravaExtrato();
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    String agenciaAntes = conta.getAgencia().getNumero() + " - " + conta.getAgencia().getCidade();
                    System.out.println("Agência atual: " + agenciaAntes +
                            "\nEscolha a nova agência: ");
                    conta.setAgencia((Agencia) MostraListas.mostraItens(agencias));
                    gravaHistorico("Agência atualizada! De: " + agenciaAntes + ", Para: " + conta.getAgencia().getNumero() + " - " + conta.getAgencia().getCidade());
                    break;
                case 3:
                    double rendaAntes = conta.getRendaMensal();
                    System.out.print("Renda mensal atual: R$ " + rendaAntes +
                            "\nDigite o novo valor: R$");
                    conta.setRendaMensal(sc.nextDouble());
                    gravaHistorico("Renda atualizada! De: " + rendaAntes + ", Para: " + conta.getRendaMensal());
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

    public static List<Conta> listaDeContas() {
        return Collections.unmodifiableList(contas);
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
                        "1 - Listar contas\n" +
                        "2 - Valor total investido\n" +
                        "3 - Todas transações(cliente único)\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            case 7:
                menuDeOpcoes = "\n=======================================\n" +
                        "----------- Listar contas -------------" +
                        "\n=======================================\n" +
                        "1 - contas corrente\n" +
                        "2 - contas poupança\n" +
                        "3 - contas investimento\n\n" +
                        "4 - Listar contas com saldo negativo\n" +
                        "5 - Listar todas as contas\n\n" +
                        "0 - Sair\n\n" +
                        "Selecione uma opção(apenas numeros): ";
                break;
            default:
                System.out.println("Opção inválida");
        }
        return menuDeOpcoes;
    }

    private static void adicionaConta(Conta conta) {
        conta.gravaConta();
        contas.add(conta);
        String tipoConta = "";
        if (conta instanceof ContaCorrente) {
            tipoConta = "Corrente";
        } else if (conta instanceof ContaPoupanca) {
            tipoConta = "Poupança";
        } else if (conta instanceof ContaInvestimento) {
            tipoConta = "Investimento";
        }
        gravaHistorico("Conta " + tipoConta + " criada! Nome: " + conta.getNome() + ", cpf: " + conta.getCpf() + " - " + conta.mostraData() + "\n");
    }
    //este metodo foi usado apenas para testes
    /*private static void adicionaAgencia(Agencia agencia) {
        agencia.gravaAgencia();
        agencias.add(agencia);
    }*/

    public static void carregaAgencias(){
        List<String> lista = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("documentos/agencias/agencias.txt"));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                lista.add(linha);
            }
            for (String s : lista) {
                String[] dados = s.split(";");
                String numeroAgencia = dados[0];
                String cidadeAgencia = dados[1];
                Agencia agencia = new Agencia(numeroAgencia,cidadeAgencia);
                agencias.add(agencia);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void carregaContas() {
        List<String> lista = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("documentos/contas/contas.txt"));
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                lista.add(linha);
            }
            for (String s : lista) {
                String[] dados = s.split(";");
                String tipo = dados[0];
                int id = Integer.parseInt(dados[1]);
                double saldo = Double.parseDouble(dados[2]);
                String nome = dados[3];
                String cpf = dados[4];
                double renda = Double.parseDouble(dados[5]);
                String numeroAgencia = dados[6];
                String cidadeAgencia = dados[7];
                Agencia agencia = new Agencia(numeroAgencia,cidadeAgencia);
                if (tipo.equals("CC")) {
                    Conta conta = new ContaCorrente(nome, cpf, renda);
                    conta.setIdentificador(id);
                    conta.setSaldo(saldo);
                    conta.setAgencia(agencia);
                    contas.add(conta);
                    conta.carregaTransacoes();
                } else if (tipo.equals("CP")) {
                    Conta conta = new ContaPoupanca(nome, cpf, renda);
                    conta.setIdentificador(id);
                    conta.setSaldo(saldo);
                    conta.setAgencia(agencia);
                    contas.add(conta);
                    conta.carregaTransacoes();
                } else if (tipo.equals("CI")) {
                    Conta conta = new ContaInvestimento(nome, cpf, renda);
                    conta.setIdentificador(id);
                    conta.setSaldo(saldo);
                    conta.setAgencia(agencia);
                    contas.add(conta);
                    conta.carregaTransacoes();
                }

            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void regravaInformacoes() {
        try (FileWriter fw = new FileWriter("documentos/contas/contas.txt", false);
             PrintWriter pw = new PrintWriter(fw)) {
            for (Conta c : contas) {
                String dadosConta = String.format(Locale.US, "%s;%05d;%.2f;%s;%s;%.2f;%s;%s", c.getTipo(), c.getIdentificador(), c.getSaldo(), c.getNome(), c.getCpf(), c.getRendaMensal(),c.getAgencia().getNumero(),c.getAgencia().getCidade());
                pw.println(dadosConta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void verificaArquivos() throws IOException {
        for (Conta conta : contas) {
            File file = new File("documentos/transacoes");
            File[] arquivos = file.listFiles();
            for (File f : arquivos) {
                if (!f.getName().equals(conta.getNome())) {
                    f.delete();
                }
            }
        }
    }

    public static void gravaHistorico(String dados) {
        try (FileWriter fw = new FileWriter("documentos/historico/historico.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            String gravacao = dados;
            pw.println(gravacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String mostraHistorico(){
        try {
            Scanner sc = new Scanner(new File("documentos/historico/historico.txt"));
            String historico = "\n--------Histórico--------\n\n";
            while (sc.hasNextLine()) {
                historico+=sc.nextLine();
            }
            sc.close();
            return historico;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Sem dados no Histórico";
    }
}
