import Polinomul_de_interpolare_Lagrange.Secvential;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class SecventialTest {

    private double epsilon = 0.00000000000001;

    @Test
    public void test_corectitudine_1(){
        Secvential sec = new Secvential("date_de_test.txt");
        double val=sec.start();

        assertEquals(-10.2,val,epsilon);

    }
    @Test
    public void test_corectitudine_2(){
        Secvential sec = new Secvential("date_de_testv2.txt");
        double val=sec.start();

        assertEquals(231,val,epsilon);

    }
}