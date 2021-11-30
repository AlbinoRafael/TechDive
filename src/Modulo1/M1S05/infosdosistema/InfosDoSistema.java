package infosdosistema;

import javax.management.ObjectName;
import javax.net.ssl.ManagerFactoryParameters;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Locale;

public class InfosDoSistema {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        double memoriaTotal = (double)((Runtime.getRuntime().maxMemory()/1024)/1024)/1024;
        double memoriaLivre = (double)((Runtime.getRuntime().freeMemory()/1024)/1024)/1024;
        double memoriaAlocada = memoriaTotal - memoriaLivre;

        System.out.println("Sistema Operacional: "+System.getProperty("os.name"));
        System.out.printf("Memória RAM total: %.2f Gb", memoriaTotal);
        System.out.printf("%nMemória RAM alocada: %.2f Gb", memoriaAlocada);
        System.out.printf("%nMemória RAM livre: %.2f Gb", memoriaLivre);
    }
}
