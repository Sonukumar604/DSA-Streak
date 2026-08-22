
public class UniquePaths {
    public int uniquePaths(int A, int B) {
        // Total moves needed
        int N = A + B - 2;
        // Number of Down moves needed (or Right moves)
        int r = A - 1;
        
        double res = 1;

        // Calculate N C r = (N * (N-1) * ... * (N-r+1)) / (1 * 2 * ... * r)
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }

        return (int) Math.round(res);
    }
}
