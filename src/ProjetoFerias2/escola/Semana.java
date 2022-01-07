package escola;

import java.time.LocalDate;

public class Semana {
    public static int id=1;
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
        id++;
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
            if(docente1.getEscalaDeTrabalho()==1){
                docente1.getEscalas().add(escala1);
                docente2.getEscalas().add(escala2);
            }else if(docente1.getEscalaDeTrabalho()==2){
                docente1.getEscalas().add(escala2);
                docente2.getEscalas().add(escala1);
            }
        }else{
            String escala="";
            for(int i=0; i<5;i++) {
                escala += dataInicio.plusDays(i).toString()+"\n";
            }
            docente1.getEscalas().add(escala);
        }

    }
}
