package escola;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Turma {
    public static int idTurma = 1;
    private List<String> assuntos = new ArrayList<>();
    private List<Semana> semanas = new ArrayList<>();
    private List<Docente>docentes = new ArrayList<>();
    private int identificacao;
    private String nomeTurma;
    private int qtdAlunos;
    private LocalDate inicioAulas;

    {
        assuntos.add("HTML/CSS");
        assuntos.add("Kanban + Terminal");
        assuntos.add("Versionamento");
        assuntos.add("Java");
        assuntos.add("SQL");
        assuntos.add("Scrum");
        assuntos.add("SQL + Java");
        assuntos.add("Java Web");
        assuntos.add("Java EE");
        assuntos.add("Devops");
        assuntos.add("Virtualização");
        assuntos.add("Mensageria");
        assuntos.add("Design Patterns");
        assuntos.add("Segurança da Internet");
        assuntos.add("Gestão de Tempo");
    }


    public Turma(){
        this.identificacao = idTurma;
        idTurma++;
    }

    public Turma(String nomeTurma, int qtdAlunos, String inicioAulas) {
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = qtdAlunos;
        this.inicioAulas = iniciaAulas(inicioAulas);
        this.identificacao = idTurma;
        setaSemanas();
        inicializaAssuntoSemana();
        idTurma++;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public String getNomeTurma() {
        return nomeTurma;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public LocalDate getInicioAulas() {
        return inicioAulas;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public List<Semana> getSemanas() {
        return semanas;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }
    public LocalDate iniciaAulas(String dataInicio){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dtInicio = LocalDate.parse(dataInicio,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return dtInicio;
    }

    public void setaSemanas(){
        LocalDate dataInicio = this.getInicioAulas();
        LocalDate dataFim = dataInicio.plusDays(4);
        for(int i=0; i<52; i++){
            semanas.add(new Semana(dataInicio,dataFim));
            dataInicio = dataInicio.plusDays(7);
            dataFim = dataFim.plusDays(7);
        }
    }

    public Semana escolheSemana() {
        int index = 1;
        String retorno = "";
        if(!this.getSemanas().isEmpty()) {
            for (Semana s:semanas) {
                retorno += index+" Semana "+index+ " ("+ s.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+"-"+
                        s.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+") - " + s.getAssunto() + "\n";
                index++;
            }
            System.out.println("\n------ Lista de todas as semanas --------\n\n"+retorno);
            Scanner sc = new Scanner(System.in);
            System.out.print("Selecione a semana: ");
            int op = sc.nextInt();
            return semanas.get(op - 1);
        }else{
            return null;
        }
    }
    public void inicializaAssuntoSemana(){
            if(this.inicioAulas!=null) {
                //html/CSS
                semanas.get(0).setAssunto(assuntos.get(0));
                semanas.get(1).setAssunto(assuntos.get(0));
                //Kanban + Terminal
                semanas.get(2).setAssunto(assuntos.get(1));
                semanas.get(3).setAssunto(assuntos.get(1));
                //Versionamento
                semanas.get(4).setAssunto(assuntos.get(2));
                semanas.get(5).setAssunto(assuntos.get(2));
                //Java
                semanas.get(6).setAssunto(assuntos.get(3));
                semanas.get(7).setAssunto(assuntos.get(3));
                semanas.get(8).setAssunto(assuntos.get(3));
                semanas.get(9).setAssunto(assuntos.get(3));
                semanas.get(10).setAssunto(assuntos.get(3));
                semanas.get(11).setAssunto(assuntos.get(3));
                semanas.get(12).setAssunto(assuntos.get(3));
                semanas.get(13).setAssunto(assuntos.get(3));
                semanas.get(14).setAssunto(assuntos.get(3));
                semanas.get(15).setAssunto(assuntos.get(3));
                //SQL
                semanas.get(16).setAssunto(assuntos.get(4));
                semanas.get(17).setAssunto(assuntos.get(4));
                semanas.get(18).setAssunto(assuntos.get(4));
                semanas.get(19).setAssunto(assuntos.get(4));
                //Scrum
                semanas.get(20).setAssunto(assuntos.get(5));
                semanas.get(21).setAssunto(assuntos.get(5));
                //SQL + Java
                semanas.get(22).setAssunto(assuntos.get(6));
                semanas.get(23).setAssunto(assuntos.get(6));
                semanas.get(24).setAssunto(assuntos.get(6));
                semanas.get(25).setAssunto(assuntos.get(6));
                //Java Web
                semanas.get(26).setAssunto(assuntos.get(7));
                semanas.get(27).setAssunto(assuntos.get(7));
                semanas.get(28).setAssunto(assuntos.get(7));
                semanas.get(29).setAssunto(assuntos.get(7));
                //Java EE
                semanas.get(30).setAssunto(assuntos.get(8));
                semanas.get(31).setAssunto(assuntos.get(8));
                semanas.get(32).setAssunto(assuntos.get(8));
                semanas.get(33).setAssunto(assuntos.get(8));
                //Devops
                semanas.get(34).setAssunto(assuntos.get(9));
                semanas.get(35).setAssunto(assuntos.get(9));
                //Virtualização
                semanas.get(36).setAssunto(assuntos.get(10));
                semanas.get(37).setAssunto(assuntos.get(10));
                //Mensageria
                semanas.get(38).setAssunto(assuntos.get(11));
                semanas.get(39).setAssunto(assuntos.get(11));
                //Design Patterns
                semanas.get(40).setAssunto(assuntos.get(12));
                semanas.get(41).setAssunto(assuntos.get(12));
                semanas.get(42).setAssunto(assuntos.get(12));
                semanas.get(43).setAssunto(assuntos.get(12));
                //Segurança da Internet
                semanas.get(44).setAssunto(assuntos.get(13));
                semanas.get(45).setAssunto(assuntos.get(13));
                semanas.get(46).setAssunto(assuntos.get(13));
                semanas.get(47).setAssunto(assuntos.get(13));
                semanas.get(48).setAssunto(assuntos.get(13));
                semanas.get(49).setAssunto(assuntos.get(13));
                //Gestão de Tempo
                semanas.get(50).setAssunto(assuntos.get(14));
                semanas.get(51).setAssunto(assuntos.get(14));
            }
    }
    @Override
    public String toString() {
        return ", identificacao=" + identificacao +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", qtdAlunos=" + qtdAlunos +
                ", inicioAulas=" + inicioAulas ;
    }
}
