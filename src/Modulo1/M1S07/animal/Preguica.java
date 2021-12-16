package animal;

public class Preguica extends Animal{

    public Preguica(String nome, int idade) {
        super(nome, idade);
    }

    @Override
    public void emitirSom(){
        System.out.println(this.getNome()+" está grunhindo...");
    }

    public void subirEmArvore(){
        System.out.println(this.getNome()+" está subindo na árvore...");
    }
}
