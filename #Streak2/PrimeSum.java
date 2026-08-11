import java.util.*;
public class PrimeSum {
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 2; i <= A / 2; i++) {
            int b = A - i;
            if (isPrime(i) && isPrime(b)) {
                result.add(i);
                result.add(b);
                return result; 
            }
        }
        return result; 
    }
    private boolean isPrime(int n) {
        if (n < 2) return false;
        int cnt = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                cnt++;
                if ((n / i) != i) {
                    cnt++;
                }
            }
        }
        return cnt == 2;
    }
}
