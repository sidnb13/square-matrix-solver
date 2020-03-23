/**
 * @title Functions for a nXn matrix
 * @author sidbaskaran
 * @date 3/22/20
 */
public class MatrixSolver {
    /**
     *
     * @param col is the index of the row to substitute the column throughout, is fixed
     * @return the subbed matrix
     */
    public static double[][] subConstants(double[][] mat, double[] cons, int col) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][col] = cons[i];
        }
        return mat;
    }

    public static double findDeterminant (double[][] mat) {
        int sum = 0;
        if (mat.length==1) {
            return mat[0][0];
        } else if (mat.length == 2) { //ab-cd
            return (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        }
        for (int i = 0; i < mat[0].length; i++) {
            double[][] smaller = new double[mat.length-1][mat[0].length-1];
            for (int j = 1; j < mat.length; j++) {
                for (int k = 0; k < mat[0].length; k++) {
                    if (k < i) {
                        smaller[j - 1][k] = mat[j][k];
                    } else if (k > i) {
                        smaller[j - 1][k - 1] = mat[j][k];
                    }
                }
            }
            sum += mat[0][i] * Math.pow(-1,i) * findDeterminant(smaller);
        }
        return sum;
    }

    public static char returnVarName (int var) {
        return (char) (var+97);
    }

}
