package escola;

import java.util.ArrayList;
import java.util.List;

public class Docente {

    public static int idDocente = 1;
    private List<String> escalas = new ArrayList<>();
    private List<Semana>semanasDefinidas = new ArrayList<>();
    private int identificacao;
    private String nomeDocente;
    private Turma turmaAtendida;

    public Docente() {
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
        this.turmaAtendida.getDocentes().add(this);
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

    public List<String> getEscalas() {
        return escalas;
    }

    public List<Semana> getSemanasDefinidas() {
        return semanasDefinidas;
    }

    public void setNomeDocente(String nomeDocente) {
        this.nomeDocente = nomeDocente;
    }

    public void setTurmaAtendida(Turma turmaAtendida) {
        this.turmaAtendida = turmaAtendida;
    }

    public String listaEscala(){
        String retorno= "";
        for(int i=0; i<escalas.size();i++){
            retorno += escalas.get(i);
        }
        return retorno;
    }

    public String listaSemanas(){
        String retorno="";
        int index = 1;
        for(int i=0; i<this.getSemanasDefinidas().size();i++){
            retorno += index + " - " + this.getSemanasDefinidas().get(i)+"\n";
            index++;
        }
        return retorno;
    }

    @Override
    public String toString() {
        return "Nome do Docente : " + nomeDocente + '\n' +
                "Turma Atendida: " + turmaAtendida.getNomeTurma()+"\n" +
                "Semanas definidas: \n"+listaSemanas();
    }
}
