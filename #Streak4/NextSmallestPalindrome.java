
public class NextSmallestPalindrome {
    public String solve(String A) {
        int n = A.length();
        char[] num = A.toCharArray();

        // 1. Check if all digits are '9'
        boolean allNines = true;
        for (int i = 0; i < n; i++) {
            if (num[i] != '9') {
                allNines = false;
                break;
            }
        }

        if (allNines) {
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for (int i = 0; i < n - 1; i++) {
                sb.append('0');
            }
            sb.append('1');
            return sb.toString();
        }

        // 2. Mirror left half to right half and track if mirrored > original
        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        // Skip middle identical characters
        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        boolean isLeftSmaller = false;
        if (i < 0 || num[i] < num[j]) {
            isLeftSmaller = true;
        }

        // Copy left half to right half
        i = mid - 1;
        j = (n % 2 == 0) ? mid : mid + 1;
        while (i >= 0) {
            num[j] = num[i];
            i--;
            j++;
        }

        // 3. If mirrored string is <= original, increment center and propagate carry
        if (isLeftSmaller) {
            int carry = 1;
            i = mid - 1;

            if (n % 2 == 1) { // Odd length
                int val = (num[mid] - '0') + carry;
                carry = val / 10;
                num[mid] = (char) ('0' + (val % 10));
                j = mid + 1;
            } else { // Even length
                j = mid;
            }

            // Propagate carry to left and mirror to right
            while (i >= 0) {
                int val = (num[i] - '0') + carry;
                carry = val / 10;
                num[i] = (char) ('0' + (val % 10));
                num[j] = num[i]; // Mirror to right
                i--;
                j++;
            }
        }

        return new String(num);
    }
}
