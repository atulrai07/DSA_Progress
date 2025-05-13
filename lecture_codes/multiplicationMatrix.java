public class multiplicationMatrix {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {4, 5},
            {6, 7}
        };

        int[][] C = new int[2][2];

        for (int i = 0; i < A.length; i++) {         // Rows of A
            for (int j = 0; j < B.length; j++) {     // Columns of B
                C[i][j] = 0;
                for (int k = 0; k < 2; k++) { // Columns of A / Rows of B
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // printing
        System.out.println("Product of matrix A and B is:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
 