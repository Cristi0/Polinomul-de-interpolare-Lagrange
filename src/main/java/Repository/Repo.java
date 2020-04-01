package Repository;

import Domain.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repo {

    public Double read(String filename, List<Pair<Double>> function){
        try {

            BufferedReader reader = new BufferedReader(new FileReader("E:/Scoala/Semestrul_6/Paradigme_si_tehnici_paralele/Lab/Proiect_PTP/src/main/resources/"+filename));//new BufferedReader(new FileReader(this.getClass().getResource("")+"../../../../resources/main/"+filename));
            String xline=reader.readLine();
            String yline=reader.readLine();
            String[] x =xline.split(",");       //se considera ca |x| = |y|
            String[] y =yline.split(",");

            for (int i = 0; i < x.length; i++) {
                function.add(new Pair(Double.parseDouble(x[i]),Double.parseDouble(y[i])));
            }
            double val = Double.parseDouble(reader.readLine());
            reader.close();
            return val;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
