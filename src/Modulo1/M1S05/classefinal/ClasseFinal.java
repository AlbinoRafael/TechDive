package M1S05.classefinal;

public class ClasseFinal {

    private String tipo;
    private ClasseFinal(){
        super();
    }
    public ClasseFinal(String tipo){
        this.tipo = tipo;
    }
    public void mensagem(){
        System.out.println("mensagem "+this.tipo+" final");
    }
}
