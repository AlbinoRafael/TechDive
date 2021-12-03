package M1S05.publicoeprivado;

public class Classe1 {

    private String frase;

    public Classe1(){
        super();
    }

    public String pegaFrase(){
        return this.frase;
    }

    public void mudaFrase(String frase){
        this.frase = frase;
    }
}
