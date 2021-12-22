package utils;

import java.util.List;

public class MostraListas {

    public String listar(List<?>lista){
        String itens = "";
        for(int i=0; i<lista.size();i++){
            itens+=lista.get(i).toString()+"\n";
        }
        return itens;
    }
}
