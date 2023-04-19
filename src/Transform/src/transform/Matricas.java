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
            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < bCols; j++) {
                    for (int k = 0; k < aCols; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
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
            for (int i = 0; i < aRows; i++) {
                for (int j = 0; j < aCols; j++) {
                    c[i][j] = a[i][j] + b[i][j];
                }
            }
            return c;
        } catch (Exception e) {
            return null;
        }
    }
}
