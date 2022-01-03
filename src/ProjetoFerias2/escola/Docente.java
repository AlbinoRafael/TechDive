package escola;

public class Docente {
    public static int idDocente = 1;
    private int identificacao;
    private String nomeDocente;
    private Turma turmaAtendida;

    public Docente(){
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
