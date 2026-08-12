
public class PowerOfTwoIntegers {
    public int isPower(int n) {
        if (n == 1) {
            return 1;
        }
        for (int a = 2; a * a <= n; a++) {
            long p = a * a; // Try powers: a^2, a^3, ...
            while (p <= n) {
                if (p == n) {
                    return 1; 
                }
                p = p * a;
            }
        }
        return 0; 
    }
}
