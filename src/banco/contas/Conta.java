package banco.contas;

import banco.cliente.Cliente;

public abstract class Conta {

    public static int id = 1;
    private int idConta;
    private Cliente cliente;

    private Conta(){}

    public Conta(Cliente cliente) {
        this.idConta = id;
        this.cliente = cliente;
        id++;
    }

    public int getIdConta() {
        return idConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String toString(){
        return "Nome do titular: "+getCliente().getNomeDoTitular();
    }
}
