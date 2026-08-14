
public class GreatestCommonDivisor {
     public int gcd(int A, int B) {
        while(A > 0 && B > 0){
            if(A > B) A = A % B;
            else B = B % A;
        }
        if(A == 0) return B;
        else return A;
    }
}
