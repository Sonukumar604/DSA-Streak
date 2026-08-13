
public class IsPalindrome {
    public int isPalindrome(int A) {
        // Negative numbers are not palindromes
        if (A < 0) {
            return 0;
        }

        int original = A;
        int revNum = 0;

        while (A > 0) {
            int lastDigit = A % 10;
            A = A / 10;
            revNum = revNum * 10 + lastDigit;
        }

        if (revNum == original) {
            return 1;
        } else {
            return 0;
        }
}
