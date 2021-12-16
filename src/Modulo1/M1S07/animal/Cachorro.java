package animal;

public class Cachorro extends Animal implements MovimentacaoAnimal{

    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void correr() {
        System.out.println("Correndo...");
    }
}
