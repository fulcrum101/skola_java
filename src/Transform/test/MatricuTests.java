import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import transform.Matricas;

public class MatricuTests {
    Matricas m;
    public MatricuTests() {
        m=new Matricas();
    }
      
    @Test
    public void testReizina(){
        double[][] a={{1,2},{3,4},{5,6}};
        double[][] b={{1,2,3},{3,2,1}};
        double[][] c={{7,6,5},{15,14,13},{23,22,21}};
        double[][] rez=m.reizina(a,b);
        for (int i=0; i<c.length; i++){
            for(int j=0; j< c[0].length; j++){
                assertEquals(c[i][j],rez[i][j]);
            }
        }
    }
    @Test
    public void testSaskaita(){
        double[][] a={{1,2},{3,4},{5,6}};
        double[][] b={{2,1},{4,3},{6,5}};
        double[][] c={{3,3},{7,7},{11,11}};
        double[][] rez=m.saskaita(a,b);
        for (int i=0; i<c.length; i++){
            for(int j=0; j< c[0].length; j++){
                assertEquals(c[i][j],rez[i][j]);
            }
        }
    }
}
