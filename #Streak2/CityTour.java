import java.util.ArrayList;
import java.util.Collections;

public class CityTour {
    private static final int MOD = 1000000007;
    public int solve(int A, ArrayList<Integer> B) {
        Collections.sort(B);
        long[] fact = new long[A + 1];
        long[] invFact = new long[A + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for(int i = 1; i <= A; i++){
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = power(fact[i], MOD -2);
        }
        long[] pow2 = new long[A + 1];
        pow2[0] = 1;
        for (int i = 1; i <= A; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }
        int unvisitedCount = 0;
        long totalWays = 1;
        long denomInv = 1;
        int L1 = B.get(0) - 1;
        if (L1 > 0) {
            unvisitedCount += L1;
            denomInv = (denomInv * invFact[L1]) % MOD;
        }
        for (int i = 0; i < B.size() - 1; i++) {
            int L = B.get(i + 1) - B.get(i) - 1;
            if (L > 0) {
                unvisitedCount += L;
                denomInv = (denomInv * invFact[L]) % MOD;
                totalWays = (totalWays * pow2[L - 1]) % MOD;
            }
        }
        int Lk = A - B.get(B.size() - 1);
        if (Lk > 0) {
            unvisitedCount += Lk;
            denomInv = (denomInv * invFact[Lk]) % MOD;
        }
        totalWays = (totalWays * fact[unvisitedCount]) % MOD;
        totalWays = (totalWays * denomInv) % MOD;

        return (int) totalWays;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
