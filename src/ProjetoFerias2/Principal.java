import escola.Docente;
import escola.Turma;
import utils.Menus;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
                    Turma turma = escolheTurma();
                    System.out.println("Selecione o docente para a turma: ");
                    Docente docente = escolheDocente();
                    turma.setDocente(docente);
                    break;
                case 4:
                    listaTurmas();
                    break;
                case 5:
                    listaDocentes();
                    break;
                case 6:
                    listaUnicoDocente();
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
        Turma turma = escolheTurma();
        Docente docente = new Docente(nomeDocente, turma);
        docentes.add(docente);
    }
    public static Turma escolheTurma(){
        int index = 1;
        String retorno = "";
        for(Turma t:turmas){
            retorno += index +" - "+t.getNomeTurma()+"\n";
            index++;
        }
        System.out.println("\n----Lista de turmas----");
        System.out.println(retorno);
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        return turmas.get(op-1);
    }
    public static Docente escolheDocente(){
        int index = 1;
        String retorno = "";
        for(Docente d:docentes){
            retorno += index +" - "+d.getNomeDocente()+"\n";
            index++;
        }
        System.out.println("\n----Lista de Docentes----");
        System.out.println(retorno);
        Scanner sc = new Scanner(System.in);
        int op = sc.nextInt();
        return docentes.get(op-1);
    }
    public static String listaTurmas(){
        String retorno = "";
        for(Turma t:turmas){
            retorno+= "\nNome da turma: "+t.getNomeTurma()+"\nAssuntos: "+t.getAssuntos()+"\nDocente: "+
                    t.getDocente()+"\n";
        }
        return retorno;
    }
    public static String listaDocentes(){
        int index = 1;
        String retorno = "";
        for(Docente d: docentes){
            retorno += index +" - "+d.getNomeDocente()+"\n";
            index++;
        }
        return retorno;
    }
    public static String listaUnicoDocente(){
        Docente docente = escolheDocente();
        return docente.toString();
    }
}
