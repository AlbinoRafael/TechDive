import escola.Docente;
import escola.Semana;
import escola.Turma;
import utils.Menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static List<Turma> turmas = new ArrayList<>();
    public static List<Docente> docentes = new ArrayList<>();

    static {
        turmas.add(new Turma("Turma A", 20, "04/03/2022"));
        turmas.add(new Turma("Turma B", 26, "04/03/2022"));

        docentes.add(new Docente("João", turmas.get(0)));
        docentes.add(new Docente("Pedro",turmas.get(0)));
        docentes.add(new Docente("Marcos",turmas.get(1)));
        docentes.add(new Docente("Maria",turmas.get(0)));
        docentes.add(new Docente("Paulo",turmas.get(1)));

    }

    public static void main(String[] args) {
        programa();
    }

    public static void programa() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            Menus.menuPrincipal();
            System.out.print("Digite uma opção acima: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    cadastraTurma();
                    break;
                case 2:
                    cadastraDocente();
                    break;
                case 3:
                    Turma turma = escolheTurma();
                    System.out.println("Escolha um docente para a "+turma.getNomeTurma());
                    Docente docente = escolheDocente();
                    docente.setTurmaAtendida(turma);
                    turma.getDocentes().add(docente);
                    for(int i=0;i<turmas.size();i++){
                        if(turmas.get(i).getIdentificacao()==turma.getIdentificacao()){
                            turmas.set(i,turma);
                        }
                    }
                    break;
                case 4:
                    docente = escolheDocente();
                    Semana semana = docente.getTurmaAtendida().escolheSemana();
                    if(semana.getDocente1()==null){
                        semana.setDocente1(docente);
                        semana.separaDias();
                        docente.getSemanasDefinidas().add(semana);
                    }else{
                        semana.setSemanaDividida(true);
                        semana.setDocente2(docente);
                        semana.separaDias();
                    }
                    for(int i=0;i<docentes.size();i++){
                        if(docentes.get(i).getIdentificacao()==docente.getIdentificacao()){
                            docentes.set(i,docente);
                            //docentes.get(i).getSemanasDefinidas().add(semana);
                        }
                    }
                    break;
                case 5:
                    listaTurmas();
                    break;
                case 6:
                    listaDocentes();
                    break;
                case 7:
                    listaUnicoDocente();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    public static void cadastraTurma() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- Cadastro de Turma -----\n");
        System.out.print("Digite o nome da turma: ");
        String nomeTurma = sc.nextLine();
        System.out.print("Digite a quantidade de alunos: ");
        int qtdAlunos = sc.nextInt();
        System.out.print("Digite a data de inicio(dd/MM/yyyy): ");
        String dtInicio = sc.next();
        Turma turma = new Turma(nomeTurma, qtdAlunos, dtInicio);
        turmas.add(turma);
    }

    public static void cadastraDocente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n----- Cadastro de Docente -----\n");
        System.out.print("Digite o nome: ");
        String nomeDocente = sc.nextLine();
        System.out.println("Escolha a turma: ");
        Turma turma = escolheTurma();
        Docente docente = new Docente(nomeDocente, turma);
        docentes.add(docente);
    }

    public static Turma escolheTurma() {
        int index = 1;
        String retorno = "";
        for (Turma t : turmas) {
            retorno += index + " - " + t.getNomeTurma() + "\n";
            index++;
        }
        System.out.println("\n----Lista de turmas----\n");
        System.out.println(retorno);
        Scanner sc = new Scanner(System.in);
        System.out.print("Selecione a turma: ");
        int op = sc.nextInt();
        return turmas.get(op - 1);
    }

    public static Docente escolheDocente() {
        int index = 1;
        String retorno = "";
        for (Docente d : docentes) {
            retorno += index + " - " + d.getNomeDocente() + "\n";
            index++;
        }
        System.out.println("\n----Lista de Docentes----\n");
        System.out.println(retorno);
        Scanner sc = new Scanner(System.in);
        System.out.print("Selecione o docente: ");
        int op = sc.nextInt();
        return docentes.get(op - 1);
    }

    public static void listaTurmas() {
        String retorno = "";
        if (!turmas.isEmpty()) {
            for (Turma t : turmas) {
                retorno += t.toString() + '\n';
            }
            System.out.println("\n-------Lista de turmas---------\n\n" + retorno);
        } else {
            System.out.println("Sem turmas definidas!");
        }

    }

    public static void listaDocentes() {
        int index = 1;
        String retorno = "";
        if (!docentes.isEmpty()) {
            for (Docente d : docentes) {
                retorno += index + " - " + d.getNomeDocente() + "\n";
                index++;
            }
            System.out.println("\n------ Lista de todos os Docentes --------\n\n" + retorno);
        } else {
            System.out.println("Sem docentes definidos!");
        }
    }

    public static void listaUnicoDocente() {
        Docente docente = escolheDocente();
        System.out.println(docente.toString());
    }


}
