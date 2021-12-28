package escola;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Turma {

    private List<String> assuntos = new ArrayList<>();
    private int identificacao;
    private String nomeTurma;
    private int qtdAlunos;
    private LocalDateTime inicioAulas;

    public Turma(){}

    public Turma(List<String> assuntos, int identificacao, String nomeTurma, int qtdAlunos, LocalDateTime inicioAulas) {
        this.assuntos = assuntos;
        this.identificacao = identificacao;
        this.nomeTurma = nomeTurma;
        this.qtdAlunos = qtdAlunos;
        this.inicioAulas = inicioAulas;
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

    public LocalDateTime getInicioAulas() {
        return inicioAulas;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public void setInicioAulas(LocalDateTime inicioAulas) {
        this.inicioAulas = inicioAulas;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "identificacao=" + identificacao +
                ", nomeTurma='" + nomeTurma + '\'' +
                ", qtdAlunos=" + qtdAlunos +
                ", inicioAulas=" + inicioAulas +
                '}';
    }
}
