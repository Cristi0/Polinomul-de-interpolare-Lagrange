package Domain;

import java.util.ArrayList;
import java.util.List;

public class Poly {
    //se pastreaza coeficientii polinomului. Pozitia lor in lista reprezentand puterea unui x asociat
    private List<Double> poly;

    public Poly() {
        this.poly = new ArrayList<>();
    }

    public List<Double> getPolinom() {
        return poly;
    }

    public void sum(List<Double> polyi) {
        int size = poly.size();

        for (int i = 0; i < size; i++) {
            poly.set(i,poly.get(i)+polyi.get(i));
        }
        if(polyi.size()>size){
            for (int i = size; i < polyi.size(); i++) {
                poly.add(polyi.get(i));
            }
        }
    }

    public void multiplyScalar( double v) {
        if(poly.size()!=0){//daca e vid
            for (int i = 0; i < poly.size(); i++) {//(k*x^n + k*x^n-1 + ...+ k*x)
                poly.set(i,(poly.get(i) * v));
            }
        }
    }
    public void divide(double remainder) {
        for (int i = 0; i < poly.size(); i++) {
            poly.set(i,poly.get(i)/remainder);
        }
    }

    public void multiply( double v) {
        if(poly.size()==0){//daca e vid
            poly.add(v);    // adaugam valoarea de la x^0
            poly.add(1.0);  //coeficientul lui x e 1
        }else{
            List<Double> newPoly =new ArrayList<>();// (x^n + x^n-1 + ... x) *(x+k) =  (k*x^n + k*x^n-1 + ...+ k*x) +(*x^n+1 + x^n + ...+ x^2)
            for (int i = 0; i < poly.size(); i++) {//(k*x^n + k*x^n-1 + ...+ k*x)
                newPoly.add((poly.get(i)*v));
            }

            for(int i=1;i< poly.size();i++){ //  (  x^n + ...+ x^2)
                newPoly.set(i,newPoly.get(i)+poly.get(i-1));
            }
            newPoly.add(poly.get(poly.size()-1)); // + x^n+1
            poly.removeAll(poly);
            poly.addAll(newPoly);
        }
    }
}
