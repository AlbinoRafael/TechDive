package banco.utils;

public class MsgPadrao {

    private MsgPadrao(){
        super();
    }
    public static void mensagem(String msg){
        System.out.println("\n****************************************************");
        System.out.println(msg);
        System.out.println("****************************************************\n");
    }
}
