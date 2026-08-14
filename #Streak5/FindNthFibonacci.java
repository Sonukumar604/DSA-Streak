
public class FindNthFibonacci {
     private static final int MOD = 1000000007;

    public int solve(int A) {
        // Base edge cases specified in the problem statement
        if (A <= 0) return 0;
        if (A == 1 || A == 2) return 1;

        // Base transformation matrix M = [[1, 1], [1, 0]]
        long[][] M = {
            {1, 1},
            {1, 0}
        };

        // Compute M^(A-1) using binary exponentiation in O(log A) time
        long[][] result = matrixPower(M, A - 1);

        // F_A is located at top-left index [0][0] of M^(A-1)
        return (int) result[0][0];
    }

    /**
     * Calculates (matrix)^p % MOD using Binary Exponentiation
     */
    private long[][] matrixPower(long[][] matrix, int p) {
        // Initialize 'res' as 2x2 Identity Matrix (acts as 1 for matrix multiplication)
        long[][] res = {
            {1, 0},
            {0, 1}
        };
        
        long[][] base = matrix;

        while (p > 0) {
            // If exponent p is ODD, multiply current base into total result
            if ((p & 1) == 1) {
                res = multiply(res, base);
            }
            
            // Square the base matrix for the next bit position
            base = multiply(base, base);
            
            // Halve exponent p (equivalent to p / 2)
            p >>= 1;
        }

        return res;
    }

    /**
     * Multiplies two 2x2 matrices (A * B) with Modulo Arithmetic
     */
    private long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];

        // Standard 2x2 Matrix Multiplication with modulo at every addition/multiplication
        C[0][0] = (A[0][0] * B[0][0] % MOD + A[0][1] * B[1][0] % MOD) % MOD;
        C[0][1] = (A[0][0] * B[0][1] % MOD + A[0][1] * B[1][1] % MOD) % MOD;
        C[1][0] = (A[1][0] * B[0][0] % MOD + A[1][1] * B[1][0] % MOD) % MOD;
        C[1][1] = (A[1][0] * B[0][1] % MOD + A[1][1] * B[1][1] % MOD) % MOD;

        return C;
    }
}
