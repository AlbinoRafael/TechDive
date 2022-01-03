package escola;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Turma {
    public static int idTurma = 1;
    private List<String> assuntos = new ArrayList<>();
    private int identificacao;
    private String nomeTurma;
    private int qtdAlunos;
    private LocalDate inicioAulas;
    private Docente docente;

    public Turma(){
        this.identificacao = idTurma;
        idTurma++;
    }

    public Turma(String nomeTurma, int qtdAlunos, LocalDate inicioAulas) {
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = qtdAlunos;
        this.inicioAulas = inicioAulas;
        this.identificacao = idTurma;
        idTurma++;
    }

    public List<String> getAssuntos() {
        return assuntos;
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

    public void setInicioAulas(LocalDate inicioAulas) {
        this.inicioAulas = inicioAulas;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "assuntos=" + assuntos +
                ", identificacao=" + identificacao +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", qtdAlunos=" + qtdAlunos +
                ", inicioAulas=" + inicioAulas +
                ", docente=" + docente +
                '}';
    }
}
