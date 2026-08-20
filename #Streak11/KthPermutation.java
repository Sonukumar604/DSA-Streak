public class KthPermutation {
    ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        // Fill numbers list with 1 to A
        for (int i = 1; i <= A; i++) {
            numbers.add(i);
        }

        // Convert B to 0-based index
        long k = B - 1;

        // If A > 20, the first (A - 20) elements will just be 1, 2, 3... 
        // because 20! > 10^18 (max value of B)
        while (A > 20) {
            result.add(numbers.remove(0));
            A--;
        }

        // Precompute factorials for up to 20 numbers
        long[] fact = new long[A + 1];
        fact[0] = 1;
        for (int i = 1; i <= A; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Apply the index division logic for the remaining elements
        for (int i = A; i >= 1; i--) {
            long blockSize = fact[i - 1];
            int index = (int) (k / blockSize);
            
            result.add(numbers.get(index));
            numbers.remove(index);
            
            k %= blockSize;
        }

        return result;
    }
}
