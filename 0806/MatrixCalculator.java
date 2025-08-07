
public class MatrixCalculator {

    public static int[][] add(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length;
        if (B.length != m || B[0].length != n) {
            throw new IllegalArgumentException("Dimensions must match");
        }
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, p = A[0].length;
        int n = B[0].length;
        if (B.length != p) {
            throw new IllegalArgumentException("A.columns must equal B.rows");
        }
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < p; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] T = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                T[j][i] = A[i][j];
            }
        }
        return T;
    }

    public static int[] minMax(int[][] A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int[] row : A) {
            for (int v : row) {
                if (v < min) {
                    min = v;
                }
                if (v > max) {
                    max = v;
                }
            }
        }
        return new int[]{min, max};
    }

    public static void printMatrix(int[][] M) {
        for (int[] row : M) {
            for (int v : row) {
                System.out.printf("%6d", v);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int[][] B = {
            {7, 8, 9},
            {10, 11, 12}
        };
        int[][] C = {
            {2, 0},
            {1, 3},
            {4, 5}
        };

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("\nA + B =");
        printMatrix(add(A, B));

        System.out.println("\nA * C =");
        printMatrix(multiply(A, C));

        System.out.println("\nTranspose of A =");
        printMatrix(transpose(A));

        int[] mm = minMax(A);
        System.out.printf("\nIn A: min = %d, max = %d%n", mm[0], mm[1]);
    }
}
