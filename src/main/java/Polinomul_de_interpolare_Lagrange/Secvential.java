package Polinomul_de_interpolare_Lagrange;

import Domain.Pair;
import Domain.Poly;
import Repository.Repo;

import java.util.ArrayList;
import java.util.List;

//todo: folosesc todo pentru  evidentierea zonelor care calculeza in mod diferit
//todo: cele cu todo calculeaza polinomul apoi inlocuieste x
//cealata varianta inluieste din start x cu valoarea data (eficienta la calcule + precizie)
public class Secvential {
    private List<Pair<Double>> valFunctie = new ArrayList<>();      //se tin minte toate x si y ale unei functii
    private Poly poly = new Poly(); // stocarea coeficientilor, pozitia reprezentat puterea lui x
    private double x;
    private Repo repo = new Repo();

    public Secvential(String filename) {
        x = repo.read(filename, valFunctie);
    }

    //cream interpolarea lagrange
    public double start() {
        double rez = Lmf(x); //calculeaza inlocuid x cu valoarea specificata la fiecare calculare        ((eroare de sistem) 0.000000000000001 1*10^-16)

//        double p = 0.0;   //todo: calculare polinom       //incluire x
//        for (int i = 0; i < poly.getPolinom().size(); i++) {   // calculeaza gasind mai intai polinomul prin toate calculele apoi inlocuid x cu valoarea data (eroare de sistem) 0.000000000000003 3*10^-16)
//            p += poly.getPolinom().get(i) * Math.pow(x, i);
//        }
//        System.out.println("p=" + p); //rezultatul pe baza incluirii
        return rez + Rmf(x);
    }

    private double Rmf(double x) {
        double rez = 0.0;
//        if (poly.getPolinom().size() > valFunctie.size()) { // daca derivata de ordinul m+1 este diferita de 0  //todo: daca se calculeaza polinomul se incluieste cu valoarea se poate calcula si restul,
//                                                                                                                //todo: in toate cazurile de testare derivata m+1 depaseste functia gasita deci rezultatul este mereu 0 la rmf
//            for (int i = 0; i < valFunctie.size(); i++) {
//                if (i < 2)
//                    rez *= (x - valFunctie.get(i).getFirst());
//                else
//                    rez *= (x - valFunctie.get(i).getFirst()) / (i - 1);
//            }
//
//            double f_derivat = 0.0;
//            double n=(valFunctie.size()+1);
//            f_derivat += n * (n + 1) / 2;
//            for (int i = valFunctie.size() ; i < poly.getPolinom().size(); i++) {
//                double val_X = Math.pow(x, i - valFunctie.size() - 1);
//                f_derivat += n * (n + 1) * val_X / 2;
//            }
//            rez*=f_derivat;
//        }
//        System.out.println(rez);
        return 0.0;
    }

    private double Lmf(double x) {
        double rez = 0.0;
        for (int k = 0; k < valFunctie.size(); k++) {
            Poly polyi = new Poly();
            rez += l(k, x, polyi) * valFunctie.get(k).getSecond();

//            // polyMultiplyScalar(valFunctie.get(k).getSecond(), polyi);//todo: calculare polinom
//            polyi.multiplyScalar(valFunctie.get(k).getSecond());
//            poly.sum(polyi.getPolinom());
        }
        return rez;
    }


    private double l(int k, double x, Poly polyi) {
        double rez = 1.0;
        double remainder;
        double xk = valFunctie.get(k).getFirst();
        for (int j = 0; j < valFunctie.size(); j++) {
            if (j != k) {
                rez *= x - valFunctie.get(j).getFirst();
                rez /= xk - valFunctie.get(j).getFirst();

//                polyi.multiply(-valFunctie.get(j).getFirst());//todo: calculare polinom
//                remainder = xk - valFunctie.get(j).getFirst();
//                polyi.divide(remainder);
            }
        }
        return rez;
    }

    public double getX() {
        return x;
    }
}
