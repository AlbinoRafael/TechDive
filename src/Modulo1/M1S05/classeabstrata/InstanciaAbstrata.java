package M1S05.classeabstrata;

public class InstanciaAbstrata {

    public static void main(String[] args) {
        ClasseAbstrata ca = new ClasseAbstrata() {
            @Override
            public void mensagem() {
                System.out.println("metodo da classe abstrata");
            }
        };
        ca.mensagem();
    }
}
