package Polinomul_de_interpolare_Lagrange;

import Domain.Pair;
import Domain.Poly;
import Repository.Repo;

import java.util.ArrayList;
import java.util.List;

public class Secvential {
    private List<Pair<Double>> valFunctie = new ArrayList<>();      //se tin minte toate x si y ale unei functii
    private Poly poly = new Poly(); // stocarea coeficientilor, pozitia reprezentat puterea lui x
    private double x;
    private Repo repo =new Repo();

    public Secvential(){
        x = repo.read("date_de_test.txt", valFunctie);
    }

    //cream interpolarea lagrange
    public double start() {
        double rez = Lmf(x)+Rmf(x); //calculeaza inlocuid x cu valoarea specificata la fiecare calculare        ((eroare de sistem) 0.000000000000001 1*10^-16)

//        double p = 0.0;   //todo: calculare ca polinom
//        for (int i = 0; i < poly.getPolinom().size(); i++) {   // calculeaza gasind mai intai polinomul prin toate calculele apoi inlocuid x cu valoarea data (eroare de sistem) 0.000000000000003 3*10^-16)
//            p+=poly.getPolinom().get(i)*Math.pow(x, i);
//        }
//        System.out.println("p="+p);
        return rez;
    }

    private double Rmf(double x) {
        return 0.0;
    }

    private double Lmf(double x) {
        double rez=0.0;
        for (int k = 0; k < valFunctie.size(); k++) {
            Poly polyi = new Poly();
            rez+=l(k,x, polyi)*valFunctie.get(k).getSecond();

//          // polyMultiplyScalar(valFunctie.get(k).getSecond(), polyi);//todo: calculare ca polinom
//           polyi.multiplyScalar(valFunctie.get(k).getSecond());
//           poly.sum(polyi.getPolinom());
        }
        return rez;
    }


    private double l(int k, double x, Poly polyi) {
        double rez=1.0;
        double remainder;
        double xk =valFunctie.get(k).getFirst();
        for (int j = 0; j < valFunctie.size(); j++) {
            if(j!=k){
                rez*=x-valFunctie.get(j).getFirst();
                rez/=xk-valFunctie.get(j).getFirst();

//                polyi.multiply(-valFunctie.get(j).getFirst());//todo: calculare ca polinom
//                remainder=xk-valFunctie.get(j).getFirst();
//                polyi.divide(remainder);
            }
        }
        return rez;
    }
}
