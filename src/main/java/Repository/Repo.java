package Repository;

import Domain.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Repo {

    public Double read(String filename, List<Pair<Double>> function){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getClass().getResource("../../../resources/main/").getPath()+filename));//new BufferedReader(new FileReader(this.getClass().getResource("")+"../../../../resources/main/"+filename));
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

    //acesta functie nu scrie in src/main/resources ci in todo build/resources/main
    public void write(String filename, List<Pair<Double>> function, Double val){
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(getClass().getResource("../../../resources/main/").getPath()+filename));//new BufferedReader(new FileReader(this.getClass().getResource("")+"../../../../resources/main/"+filename));

            for (int i = 0; i < function.size()-1; i++) {
                writer.write(function.get(i).getFirst().toString());
                writer.write(",");
            }
            writer.write(function.get(function.size()-1).getFirst().toString());
            writer.newLine();
            for (int i = 0; i < function.size()-1; i++) {
                writer.write(function.get(i).getSecond().toString());
                writer.write(",");
            }
            writer.write(function.get(function.size()-1).getSecond().toString());
            writer.newLine();
            writer.write(val.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
