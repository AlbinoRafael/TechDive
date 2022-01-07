package escola;

import java.util.ArrayList;
import java.util.List;

public class Docente {

    public static int idDocente = 1;
    private List<String> escalas =new ArrayList<>();
    private int identificacao;
    private String nomeDocente;
    private Turma turmaAtendida;
    private int escalaDeTrabalho;

    public Docente(){
        this.identificacao = idDocente;
        idDocente++;
    }
    public Docente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
        this.identificacao = idDocente;
        idDocente++;
    }

    public Docente(String nomeDocente, Turma turmaAtendida) {
        this.nomeDocente = nomeDocente;
        this.turmaAtendida = turmaAtendida;
        this.identificacao = idDocente;
        idDocente++;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public Turma getTurmaAtendida() {
        return turmaAtendida;
    }

    public int getEscalaDeTrabalho() {
        return escalaDeTrabalho;
    }

    public void setEscalaDeTrabalho(int escalaDeTrabalho) {
        this.escalaDeTrabalho = escalaDeTrabalho;
    }

    public List<String> getEscalas() {
        return escalas;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public void setTurmaAtendida(Turma turmaAtendida) {
        this.turmaAtendida = turmaAtendida;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "identificacao=" + identificacao +
                ", nomeDocente='" + nomeDocente + '\'' +
                ", turmaAtendida=" + turmaAtendida +
                '}';
    }
}
