
import java.util.*;
public class PrimeNumbers {
    public ArrayList<Integer> sieve(int A) {
        if (A < 2) {
            return new ArrayList<>();
        }
        int[] prime = new int[A + 1];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 1;
        for (long i = 2; i * i <= A; i++) {
            if (prime[(int) i] == 1) {
                // Mark multiples of i as non-prime starting from i * i
                for (long j = i * i; j <= A; j += i) {
                    prime[(int) j] = 0;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 2; i <= A; i++){
            if(prime[i] == 1){
                result.add(i);
            }
        }
        return result;
    }
}
