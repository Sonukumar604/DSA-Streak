public class KthPermutation {
    public ArrayList<Integer> findPerm(int A, Long B) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        
       int cur = 1;
        while (A > 20) {
            result.add(cur);
            cur++;
            A--;
        }
        
        long k = B - 1;
        
        for (int i = cur; i < cur + A; i++) {
            numbers.add(i);
        }
        
        long[] fact = new long[A + 1];
        fact[0] = 1;
        for (int i = 1; i <= A; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
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
