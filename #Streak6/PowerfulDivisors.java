import java.util.ArrayList;

public class PowerfulDivisors {
    private static final int MAX = 1000000;

    public ArrayList<Integer> powerfulDivisors(ArrayList<Integer> A) {
        // 1. Array to count divisors for every number up to 10^6
        int[] numDivisors = new int[MAX + 1];
        
        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                numDivisors[j]++;
            }
        }

        // 2. Build Prefix Sum Array
        int[] prefix = new int[MAX + 1];
        for (int i = 1; i <= MAX; i++) {
            int count = numDivisors[i];
            
            // Check if count is a power of 2: (count > 0 && (count & (count - 1)) == 0)
            boolean isPowerOfTwo = (count > 0) && ((count & (count - 1)) == 0);
            
            prefix[i] = prefix[i - 1] + (isPowerOfTwo ? 1 : 0);
        }

        // 3. Process each query in ArrayList A
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : A) {
            ans.add(prefix[x]);
        }

        return ans;
    }
}