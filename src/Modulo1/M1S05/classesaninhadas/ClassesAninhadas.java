package M1S05.classesaninhadas;

public class ClassesAninhadas {

    public int numero1 = 10;
    public static int numero2 = 20;

    public class ClasseInterna{
        public void retornaNumero1() {
            numero1 += 10;
            System.out.println("Numero é igual a "+numero1);
        }
    }
    public static class ClasseInternaStatic{
        public void retornaNumero2() {
            numero2 += 20;
            System.out.println("Numero é igual a "+numero2);
        }
    }

    public static void main(String[] args) {

        ClassesAninhadas ca = new ClassesAninhadas();
        ClasseInterna ci = ca.new ClasseInterna();
        ci.retornaNumero1();
        ClasseInternaStatic cis = new ClasseInternaStatic();
        cis.retornaNumero2();
    }
}
