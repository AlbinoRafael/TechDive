package construtores;

public class Construtores {

    Construtores(){
        this("José");
        System.out.println("construtor padrão");
    }
    Construtores(String nome){
        this("Pedro", 25);
        System.out.println("o nome é: "+nome);
    }
    Construtores(String nome, int idade){
        System.out.println("o nome é: "+nome+" e a idade é: "+idade);
    }

    public static void main(String[] args) {
        Construtores construtor = new Construtores();
    }
}
