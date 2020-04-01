package Analiza;

import Domain.Pair;
import Polinomul_de_interpolare_Lagrange.Secvential;
import Repository.Repo;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Timp {
    public static void main(String[] args) {
        Timp timp = new Timp();
        timp.secvential();
       // timp.createTestFile();
    }

    public void secvential() {
        long start=System.nanoTime();
        Secvential sec = new Secvential("1000 points.txt");
        sec.start();
        long stop=System.nanoTime();
        System.out.println("Timp executie secvential: "+(stop-start));
    }

    public void createTestFile() {
        Repo repo = new Repo();
        List<Pair<Double>> functie = new ArrayList<>();
        Double val = 100.0;

        for (double i = 1; i < 1001; i++) {
            if(val!=i) {
                Double y = Math.log(i);
                Pair pair = new Pair(i, y);
                functie.add(pair);
            }
        }
        repo.write("1000 points.txt", functie, val);
    }
}
