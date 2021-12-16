package animal;

public class Cavalo extends Animal implements MovimentacaoAnimal{

    public Cavalo(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom(){
        System.out.println(this.getNome()+" está relinchando...");
    }

    @Override
    public void correr() {
        System.out.println(this.getNome()+" está correndo...");
    }
}
