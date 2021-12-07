package banco.conta;

public class Agencia {
    private String numero;
    private String cidade;

    public Agencia(){
        super();
    }
    public Agencia(String numero, String cidade){
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "numero='" + numero + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
