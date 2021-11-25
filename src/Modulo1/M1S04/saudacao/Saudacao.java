package saudacao;

import java.util.Calendar;

public class Saudacao {

    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        int hr = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        String hora = Integer.toString(hr);
        String minuto = Integer.toString(min);

        if (hr < 10) hora = "0" + hr;
        if (min < 10) minuto = "0" + min;

        if (hr >= 00 && hr < 12) {
            System.out.println("Bom dia, no momento são " + hora + ":" + minuto);
        } else if (hr >= 12 && hr < 18) {
            System.out.println("Boa tarde, no momento são " + hora + ":" + minuto);
        } else {
            System.out.println("Boa noite, no momento são " + hora + ":" + minuto);
        }

    }

}

