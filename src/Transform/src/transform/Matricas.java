package transform;
public class Matricas {
    public static double[][] reizina(double[][] a, double[][] b) {
        try {
            int aRows = a.length;
            int bRows = b.length;
            int aCols = a[0].length;
            int bCols = b[0].length;
            if (bRows != aCols) {
                return null;
            }
            double[][] c = new double[aRows][bCols];
            // te jâraksta cikli
            return c;
        } catch (Exception e) {
            return null;
        }
    }

    public static double[][] saskaita(double[][] a, double[][] b) {
        try {
            int aRows = a.length;
            int bRows = b.length;
            int aCols = a[0].length;
            int bCols = b[0].length;
            if (aRows != bRows || bCols != aCols) {
                return null;
            }
            double[][] c = new double[aRows][aCols];
            // te jâraksta cikli
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
