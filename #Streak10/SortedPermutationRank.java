public class SortedPermutationRankWithR {
    private static final int MOD = 1000003;

    public int findRank(String A) {
        int n = A.length();
        
        // Step 1: Precompute factorials modulo 1000003
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        long rank = 1;

        // Step 2: Iterate through each character position
        for (int i = 0; i < n; i++) {
            int countSmaller = 0;

            // Count remaining characters strictly smaller than A.charAt(i)
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    countSmaller++;
                }
            }

            // Step 3: Compute term modulo 1000003 at every addition step
            long term = (countSmaller * fact[n - 1 - i]) % MOD;
            rank = (rank + term) % MOD;
        }

        return (int) rank;
    }
}
