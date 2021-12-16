package animal;

public class Cavalo extends Animal implements MovimentacaoAnimal{

    public Cavalo(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void correr() {
        System.out.println("Correndo...");
    }
}
