package hotel.util;

import hotel.Hospede;
import hotel.Hotel;
import hotel.Quarto;
import hotel.agenda.Reserva;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Listar {

    public static String listaHospedes() {
        String retorno = "\nLista de Hóspedes cadastrados\n";
        int index = 1;
        List<Hospede>listaDeHospedes = new ArrayList<>(Hotel.getHospedes());
        Collections.sort(listaDeHospedes);
        for (Hospede h : listaDeHospedes) {
            retorno += "\n"+index+" - "+h.toString();
            index++;
        }
        return retorno;
    }
    public static String listaQuartos(){
        String retorno = "\nLista de todos os Quartos\n";
        int index = 1;
        for(Quarto q: Hotel.getQuartos()){
            retorno+="\n"+index+" - "+q.toString();
            index++;
        }
        return retorno;
    }
    public static String listaQuartosDisponiveis(){
        String retorno = "\nLista de quartos disponíveis\n";
        int index = 1;
        for(Quarto q: Hotel.getQuartos()){
            if(q.isEstaDisponivel()){
                retorno+="\n"+index+" - "+q.toString();
                index++;
            }
        }
        return retorno;
    }
    public static String listaQuartosNaoDisponiveis(){
        String retorno = "\nLista de quartos não disponíveis\n";
        int index = 1;
        for(Quarto q: Hotel.getQuartos()){
            if(!q.isEstaDisponivel()){
                retorno+="\n"+index+" - "+q.toString();
                index++;
            }
        }
        return retorno;
    }
    public static String listaReservas(){
        String retorno = "";
        int index = 1;
        for(Reserva r: Hotel.getReservas()){
            retorno+="\n"+index+" - "+r.toString();
            index++;
        }
        return retorno;
    }
    public static Hospede escolheHospede(List<Hospede>hospedes){
        Scanner sc = new Scanner(System.in);
        System.out.println(listaHospedes());
        List<Hospede> hospedesOrdenados = new ArrayList<>(Hotel.getHospedes());
        Collections.sort(hospedesOrdenados);
        System.out.print("Selecione o hospede: ");
        int op = sc.nextInt();
        return hospedesOrdenados.get(op-1);
    }
    public static Quarto escolheQuarto(List<Quarto>quartos){
        Scanner sc = new Scanner(System.in);
        System.out.println(listaQuartos());
        System.out.print("Selecione o quarto: ");
        int op = sc.nextInt();
        return Hotel.getQuartos().get(op-1);
    }

    public static Reserva escolheReserva(List<Reserva>reservas){
        Scanner sc = new Scanner(System.in);
        System.out.println(listaReservas());
        System.out.print("Selecione a reserva: ");
        int op = sc.nextInt();
        return Hotel.getReservas().get(op-1);
    }
}
