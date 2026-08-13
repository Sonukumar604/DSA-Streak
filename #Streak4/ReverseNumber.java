
public class ReverseNumber {
    public int reverse(int A) {
        long revNum = 0;
        
        while (A != 0) {
            int lastDigit = A % 10;
            revNum = revNum * 10 + lastDigit;
            A = A / 10;
        }

        // Handle 32-bit integer overflow/underflow
        if (revNum > Integer.MAX_VALUE || revNum < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) revNum;
    }
}
