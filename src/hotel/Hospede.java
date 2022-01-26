package hotel;

import hotel.agenda.Reserva;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hospede implements Comparable<Hospede>{

    private List<Reserva> reservas = new ArrayList<>();

    private String nome;
    private String sobrenome;
    private String documentoIdentificacao;
    private String dataNascimento;

    public Hospede(String nome, String sobrenome, String documentoIdentificacao, String dataNascimento) {
        if(nome!=null && !nome.isBlank()&& !nome.isEmpty()){this.nome = nome;}
        if(sobrenome!=null && !sobrenome.isBlank()&& !sobrenome.isEmpty()){this.sobrenome = sobrenome;}
        if(validaCPF(documentoIdentificacao)||validaRG(documentoIdentificacao)){this.documentoIdentificacao = documentoIdentificacao;}
        if(validaDataNascimento(dataNascimento)){this.dataNascimento = dataNascimento;}
    }

    public List<Reserva> getReservas() {
        return Collections.unmodifiableList(reservas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    public void setDocumentoIdentificacao(String documentoIdentificacao) {
        this.documentoIdentificacao = documentoIdentificacao;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return nome.equals(hospede.nome) && documentoIdentificacao.equals(hospede.documentoIdentificacao) && dataNascimento.equals(hospede.dataNascimento);
    }

    @Override
    public String toString() {
        return nome +' '+sobrenome;
    }

    @Override
    public int compareTo(Hospede o) {
        return this.getNome().compareTo(o.getNome());
    }

    public boolean validaCPF(String cpf) {
        boolean isValido = false;
        if (cpf.length() == 11 && cpf.matches("[+-]?\\d*(\\.\\d+)?") && !cpf.contains("^[a-zA-Z]") &&
                !cpf.equals(null) && !cpf.isBlank() && !cpf.contains(" ")) {
            int contador = 1;
            char[] cpfs = cpf.toCharArray();
            for (int i = 0; i < cpfs.length - 1; i++) {
                if (cpfs[i] == cpfs[i + 1]) {
                    contador++;
                }
            }
            if (contador == cpf.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

    public boolean validaRG(String rg) {
        boolean isValido = false;
        if (rg.length() == 8 && rg.matches("[+-]?\\d*(\\.\\d+)?") && !rg.contains("^[a-zA-Z]") &&
                !rg.equals(null) && !rg.isBlank() && !rg.contains(" ")) {
            int contador = 1;
            char[] rgs = rg.toCharArray();
            for (int i = 0; i < rgs.length - 1; i++) {
                if (rgs[i] == rgs[i + 1]) {
                    contador++;
                }
            }
            if (contador == rg.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

    public boolean validaDataNascimento(String dataNascimento) {
        boolean isValido = false;
        if (dataNascimento.length() == 10 && !dataNascimento.contains("^[a-zA-Z]") &&
                !dataNascimento.equals(null) && !dataNascimento.isBlank() && !dataNascimento.contains(" ")) {
            int contador = 1;
            char[] rgs = dataNascimento.toCharArray();
            for (int i = 0; i < rgs.length - 1; i++) {
                if (rgs[i] == rgs[i + 1]) {
                    contador++;
                }
            }
            if (contador == dataNascimento.length()) {
                isValido = false;
            } else {
                isValido = true;
            }
        }
        return isValido;
    }

    public void adicionaReserva(Reserva reserva) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        reservas.add(reserva);

        String historico="\nHistórico de hóspedes\n\n";
        for(int i=0; i<Hotel.getQuartos().size();i++){
            if(reserva.getQuarto().getNumeroQuarto() == Hotel.getQuartos().get(i).getNumeroQuarto()){
                historico+= this +" - "+dtf.format(this.getReservas().get(i).getDataAgendamento())+"/"+dtf.format(this.getReservas().get(i).getDataFimAgendamento())+'\n';
                Hotel.getQuartos().get(i).setHistorico(historico);

            }
            if(Hotel.getQuartos().get(i).getHistorico()==null){
                historico = "\nSem histórico de hóspedes\n";
                Hotel.getQuartos().get(i).setHistorico(historico);
            }
        }

    }

    public void removeReserva(Reserva reserva) {
        reservas.remove(reserva);
    }

    public void registraReserva(Reserva reserva) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inicioAltaTemporada = LocalDate.parse("01-10-" + LocalDate.now().getYear(), dtf);
        LocalDate fimAltaTemporada = LocalDate.parse("31-03-" + LocalDate.now().plusYears(1).getYear(), dtf);
        for (int i=0; i<Hotel.getQuartos().size();i++) {
            if (Hotel.getQuartos().get(i).getNumeroQuarto() == reserva.getQuarto().getNumeroQuarto()) {
                if (reserva.getDataAgendamento().isAfter(inicioAltaTemporada) && reserva.getDataAgendamento().isBefore(fimAltaTemporada)) {
                    if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SIMPLES)) {
                        reserva.getQuarto().setValorDiaria(140);
                    } else if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.LUXO)) {
                        reserva.getQuarto().setValorDiaria(400);
                    } else if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SUPREMA)) {
                        reserva.getQuarto().setValorDiaria(800);
                    } else {
                        if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SIMPLES)) {
                            reserva.getQuarto().setValorDiaria(90);
                        } else if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.LUXO)) {
                            reserva.getQuarto().setValorDiaria(150);
                        } else if (reserva.getQuarto().getTipoQuarto().equals(EnumTipoQuarto.SUPREMA)) {
                            reserva.getQuarto().setValorDiaria(500);
                        }
                        reservas.add(reserva);
                        String historico="\nHistórico de hóspedes\n\n";
                        for(int j=0; j<Hotel.getQuartos().size();j++){
                            if(reserva.getQuarto().getNumeroQuarto() == Hotel.getQuartos().get(j).getNumeroQuarto()){
                                historico+=this+" - "+dtf.format(reserva.getDataAgendamento())+"/"+dtf.format(reserva.getDataFimAgendamento())+'\n';
                                Hotel.getQuartos().get(j).setHistorico(historico);
                            }
                            if(Hotel.getQuartos().get(j).getHistorico() == null){
                                historico = "\nSem histórico de hóspedes!\n";
                                Hotel.getQuartos().get(j).setHistorico(historico);
                            }
                        }
                        System.out.println("\nReserva feita para " + this + ", quarto Nº: " + reserva.getQuarto().getNumeroQuarto() + "\n");
                    }
                }
            }
        }
    }

    public void cancelaReserva(Reserva reserva) {
        for (int i=0; i<Hotel.getQuartos().size();i++) {
            for(int j=0; j<this.getReservas().size();j++) {
                if (Hotel.getQuartos().get(i).getNumeroQuarto() == this.getReservas().get(j).getQuarto().getNumeroQuarto()) {
                    reservas.remove(reserva);
                }
            }
        }

    }
}
