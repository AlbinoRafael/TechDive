package hotel.agenda;

import hotel.Hospede;
import hotel.Quarto;

import java.time.LocalDate;

public class Reserva {

   private LocalDate dataAgendamento;
   private Hospede hospede;
   private Quarto quarto;

   public Reserva(Hospede hospede, Quarto quarto) {
      this.hospede = hospede;
      this.quarto = quarto;
   }

   public void agendarReserva(String dataAgendamento){
      LocalDate dataAgenda = LocalDate.parse(dataAgendamento);
      if(dataAgenda.isAfter(LocalDate.now().plusDays(60))) {
         if (quarto.isEstaDisponivel()) {
            this.dataAgendamento = dataAgenda;
         }else{
            System.err.println("O quarto não está disponível para reserva!");
         }
      }else{
         System.err.println("Você precisa agendar com pelo menos 60 dias de antecedência!");
      }
   }

   public LocalDate getDataAgendamento() {
      return dataAgendamento;
   }

   public void setDataAgendamento(LocalDate dataAgendamento) {
      this.dataAgendamento = dataAgendamento;
   }

   public Hospede getHospede() {
      return hospede;
   }

   public void setHospede(Hospede hospede) {
      this.hospede = hospede;
   }

   public Quarto getQuarto() {
      return quarto;
   }

   public void setQuarto(Quarto quarto) {
      this.quarto = quarto;
   }

   @Override
   public String toString() {
      return "hospede " + hospede.getNome() +" "+ hospede.getSobrenome()+
              ", quarto " + quarto.getNumeroQuarto();
   }
}
