package escola;

public class Docente {

    private int identificacao;
    private String nomeDocente;
    private Turma turmaAtendida;

    public Docente(){}

    public Docente(int identificacao, String nomeDocente, Turma turmaAtendida) {
        this.identificacao = identificacao;
        this.nomeDocente = nomeDocente;
        this.turmaAtendida = turmaAtendida;
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

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
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
