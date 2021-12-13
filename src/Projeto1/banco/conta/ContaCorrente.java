package banco.conta;
import banco.servico.Transacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ContaCorrente extends Conta{

    public ContaCorrente(){
        super();
    }

    public ContaCorrente(String nome, String cpf, double rendaMensal){
        super();
        super.setNome(nome);
        super.setCpf(cpf);
        super.setRendaMensal(rendaMensal);
    }

    @Override
    public void saque(double valorSaque){
        if(this.getSaldo()>= this.limiteChequeEspecial()) {
            Transacao transacao = new Transacao(this,valorSaque);
            transacao.setTipo("Saque");
            transacao.setValor(valorSaque);
            this.setSaldo(this.getSaldo() - transacao.getValor());
            this.setExtrato(transacao.toString());
            this.getTransacoes().add(transacao);
        }
    }

    public double limiteChequeEspecial(){
        return -(this.getRendaMensal());
    }

    public String periodoFicarNegativado(){
        LocalDate dtAtual = LocalDate.now();
        LocalDate dtLimite = LocalDate.now().plusDays(30);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate diferenca = dtLimite.minusDays(dtAtual.getDayOfMonth());
        String dataLimite = diferenca.format(dtf);
        if(this.getSaldo()<0){
            System.out.println("Data limite: "+dataLimite);
        }
        return dataLimite;
    }
}
