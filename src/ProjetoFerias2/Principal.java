import escola.Docente;
import escola.Turma;
import utils.Menus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static List<Turma> turmas = new ArrayList<>();
    public static List<Docente> docentes = new ArrayList<>();

    public static void main(String[] args) {
        programa();
    }
    public static void programa(){
        Scanner sc = new Scanner(System.in);
        int op;
        do{
            Menus.menuPrincipal();
            System.out.print("Digite uma opção acima: ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    cadastraTurma();
                    break;
                case 2:
                    cadastraDocente();
                    break;
                case 3:
                    System.out.println("Selecione a turma: ");
                    Turma turma = escolheTurma(turmas);
                    System.out.println("Selecione o docente para a turma: ");
                    Docente docente = escolheDocente(docentes);
                    turma.setDocente(docente);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
            }
        }while(op!=0);
    }
    public static void cadastraTurma(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- Cadastro de Turma -----\n");
        System.out.print("Digite o nome da turma: ");
        String nomeTurma = sc.nextLine();
        System.out.print("Digite a quantidade de alunos: ");
        int qtdAlunos = sc.nextInt();
        System.out.print("Digite a data de inicio(dd/MM/yyyy): ");
        String dtInicio = sc.next();
        LocalDate dataInicio = LocalDate.parse(dtInicio,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Turma turma = new Turma(nomeTurma,qtdAlunos,dataInicio);
        int op;
        do{
            Menus.menuAssuntos();
            System.out.print("Digite uma opção acima: ");
            op = sc.nextInt();
            switch (op){
                case 1:
                    turma.getAssuntos().add("Java");
                    break;
                case 2:
                    turma.getAssuntos().add("C/C++");
                    break;
                case 3:
                    turma.getAssuntos().add("C#");
                    break;
                case 4:
                    turma.getAssuntos().add("Python");
                    break;
                case 5:
                    turma.getAssuntos().add("Banco de Dados");
                    break;
                case 0:
                    break;
            }
        }while(op!=0);
        turmas.add(turma);
    }
    public static void cadastraDocente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- Cadastro de Docente -----\n");
        System.out.print("Digite o nome: ");
        String nomeDocente = sc.nextLine();
        System.out.println("Escolha a turma: ");
        Turma turma = escolheTurma(turmas);
        Docente docente = new Docente(nomeDocente, turma);
        docentes.add(docente);
    }
    public static Turma escolheTurma(List<Turma>lista){
        int index = 1;
        String retorno = "";
        for(int i =0; i<lista.size();i++){
            retorno += index +" - "+lista.get(i).getNomeTurma()+"\n";
            index++;
        }
        System.out.println("\n----Lista de turmas----");
        System.out.println(retorno);
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        return lista.get(op-1);
    }
    public static Docente escolheDocente(List<Docente>lista){
        int index = 1;
        String retorno = "";
        for(int i =0; i<lista.size();i++){
            retorno += index +" - "+lista.get(i).getNomeDocente()+"\n";
            index++;
        }
        System.out.println("\n----Lista de Docentes----");
        System.out.println(retorno);
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        return lista.get(op-1);
    }
}
