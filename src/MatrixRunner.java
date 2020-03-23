import java.util.LinkedHashMap;

public class MatrixRunner {
    public static void main(String[] args) {

        double[][] matrix = new double[3][3];
        double[] constants;
        LinkedHashMap<Character,Double> solutions = new LinkedHashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            matrix = new double[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 0}};
            constants = new double[]{5, 3, 9};
            double b = MatrixSolver.findDeterminant(matrix);
            double a = MatrixSolver.findDeterminant(MatrixSolver.subConstants(matrix, constants,i));
            solutions.put(MatrixSolver.returnVarName(i),a/b);
        }
        System.out.println(solutions);
    }

    public static void printMat (double[][] arr) {
        for (double[] doubles : arr) {
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print((int)doubles[col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
