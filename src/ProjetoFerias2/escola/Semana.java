package escola;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Semana {
    public static int id=1;
    private int identificacao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String assunto;
    private boolean semanaDividida = false;
    private Docente docente1;
    private Docente docente2 = null;

    private Semana(){}

    public Semana(LocalDate dataInicio, LocalDate dataFim){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.identificacao =id;
        id++;
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public String getAssunto() {
        return assunto;
    }

    public Docente getDocente1() {
        return docente1;
    }

    public Docente getDocente2() {
        return docente2;
    }

    public void setDocente2(Docente docente2) {
        this.docente2 = docente2;
    }

    public boolean isSemanaDividida() {
        return semanaDividida;
    }

    public void setSemanaDividida(boolean semanaDividida) {
        this.semanaDividida = semanaDividida;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public void setDocente1(Docente docente1) {
        this.docente1 = docente1;
    }

    public void separaDias(){

        if(this.isSemanaDividida()){
            String escala1="";
            String escala2="";

            for(int i=0; i<2;i++) {
                escala1 += dataInicio.plusDays(i).toString()+"\n";
            }
            for(int i=2; i<5;i++) {
                escala2 += dataInicio.plusDays(i).toString()+"\n";
            }
            docente1.getEscalas().add(escala1);
            docente2.getEscalas().add(escala2);
        }else{
            String escala="";
            for(int i=0; i<5;i++) {
                escala += dataInicio.plusDays(i).toString()+"\n";
            }
            docente1.getEscalas().add(escala);
        }

    }

    @Override
    public String toString() {
        return "Semana "+getIdentificacao()+" (" +this.getDataInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "-" +
                this.getDataFim().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ") - " + this.getAssunto();
    }
}
