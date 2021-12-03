package M1S05.ordemdeinicializacao;

public class OrdemDeInicializacao {

    public OrdemDeInicializacao(){
        System.out.println("dentro do construtor");
    }
    static{
        System.out.println("dentro do bloco static");
    }
    {
        System.out.println("dentro do bloco de instancia");
    }

    public static void main(String[] args) {
        new OrdemDeInicializacao();
    }
}
