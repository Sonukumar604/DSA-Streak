public class SortedPermutationRankWithRepeats {
    private static final int MOD = 1000003;

    public int findRank(String A) {
        int n = A.length();

        // Step 1: Precompute factorials
        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        // Step 2: Build initial character frequency map
        int[] freq = new int[256];
        for (int i = 0; i < n; i++) {
            freq[A.charAt(i)]++;
        }

        long rank = 1;

        // Step 3: Iterate through each character position
        for (int i = 0; i < n; i++) {
            char curr = A.charAt(i);

            // Count characters strictly smaller than 'curr' that are still available
            for (char ch = 0; ch < curr; ch++) {
                if (freq[ch] == 0) continue;

                // Temporarily place 'ch' at current position
                freq[ch]--;

                // Denominator = product of (freq[c]!) for all remaining characters
                long denom = 1;
                for (int c = 0; c < 256; c++) {
                    if (freq[c] > 1) {
                        denom = (denom * fact[freq[c]]) % MOD;
                    }
                }

                // Ways to arrange remaining characters = (n - 1 - i)! / denom
                long count = (fact[n - 1 - i] * modInverse(denom, MOD)) % MOD;
                rank = (rank + count) % MOD;

                // Backtrack character frequency
                freq[ch]++;
            }

            // Permanently consume the current character
            freq[curr]--;
        }

        return (int) rank;
    }

    // Fermat's Little Theorem for Modular Inverse: a^(MOD - 2) % MOD
    private long modInverse(long n, int mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}
