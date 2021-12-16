package animal;

public class Cachorro extends Animal implements MovimentacaoAnimal{

    public Cachorro(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom(){
        System.out.println(this.getNome()+" está latindo...");
    }

    @Override
    public void correr() {
        System.out.println(this.getNome()+" está correndo...");
    }
}
