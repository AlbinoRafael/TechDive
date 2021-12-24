package utils;

public class Menu {

    public static void menuPrincipal(){
        System.out.println("\n=========================================================");
        System.out.println("|             Gerenciamento de Funcionários             |");
        System.out.println("=========================================================");
        System.out.println("| 1 - Adicionar funcionário                             |");
        System.out.println("| 2 - Ver detalhes (Funcionário)                        |");
        System.out.println("| 3 - Demitir funcionário                               |");
        System.out.println("| 4 - Atualizar informações (Funcionário)               |");
        System.out.println("| 5 - Listar todos os funcionários                      |");
        System.out.println("| 6 - Listar funcionários ativos                        |");
        System.out.println("| 7 - Listar funcionários desativados                   |");
        System.out.println("| 0 - Sair                                              |");
        System.out.println("=========================================================");
    }
    public static void menuAdicionaFuncionario(){
        System.out.println("\n=========================================================");
        System.out.println("|                Adicionar um Funcionário               |");
        System.out.println("=========================================================");
        System.out.println("| 1 - Colaborador                                       |");
        System.out.println("| 2 - Líder Técnico                                     |");
        System.out.println("| 3 - Gerente de Departamento                           |");
        System.out.println("| 4 - Gerente Geral                                     |");
        System.out.println("| 0 - Sair                                              |");
        System.out.println("=========================================================");
    }
    public static void menuDefineDepartamento(){
        System.out.println("\n=========================================================");
        System.out.println("|                Escolha de Departamento                |");
        System.out.println("=========================================================");
        System.out.println("| 1 - Administrativo                                    |");
        System.out.println("| 2 - Financeiro                                        |");
        System.out.println("| 3 - Comercial                                         |");
        System.out.println("| 4 - Recursos Humanos                                  |");
        System.out.println("| 5 - Operacional                                       |");
        System.out.println("=========================================================");
    }
    public static void menuAtualizaInformacoesFuncionario(){
        System.out.println("\n=========================================================");
        System.out.println("|              Atualização de Informações               |");
        System.out.println("=========================================================");
        System.out.println("| 1 - Nome                                              |");
        System.out.println("| 2 - Idade                                             |");
        System.out.println("| 3 - Salário                                           |");
        System.out.println("| 4 - Departamento                                      |");
        System.out.println("| 5 - Benefícios/Bonificações                           |");
        System.out.println("| 6 - Situação                                          |");
        System.out.println("| 0 - Sair                                              |");
        System.out.println("=========================================================");
    }
}
