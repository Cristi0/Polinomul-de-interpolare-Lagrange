package Source;

import Polinomul_de_interpolare_Lagrange.Secvential;

public class StartSecvential {
    public static void main(String[] args) {
        Secvential sec = new Secvential("date_de_test.txt");
        System.out.println("f("+sec.getX()+")= "+sec.start());
    }
}
