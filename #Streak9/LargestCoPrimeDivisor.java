
public class LargestCoPrimeDivisor {
    public int cpFact(int A, int B) {
        while(gcd(A, B) != 1){
            A = A/gcd(A, B);
        }
        return A;
    }
    private static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
}
