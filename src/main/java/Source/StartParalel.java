package Source;


import Polinomul_de_interpolare_Lagrange.Secvential;
import mpi.MPI;

public class StartParalel {
    public static void main(String[] args) {

        MPI.Init(args);
       // final Intracomm comm = MPI.COMM_WORLD;

        System.out.println("salut");
        MPI.Finalize();
    }
}
