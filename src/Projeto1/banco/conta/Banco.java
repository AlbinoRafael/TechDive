package banco.conta;

public class Banco {

    public Banco(){}

    public static void main(String[] args) {
        Conta conta1 = new Conta() {
            @Override
            public String getExtrato() {
                return super.getExtrato();
            }
        };
        Conta conta2 = new Conta() {
            @Override
            public void setSaldo(double saldo) {
                super.setSaldo(saldo);
            }
        };
        conta1.setSaldo(1000);
        conta1.saque(250);
        conta1.deposito(720);
        conta2.setSaldo(2000);
        conta1.transferir(conta2, 500);
        System.out.println(conta1.getExtrato());
        System.out.println(conta2.getExtrato());
    }
}
