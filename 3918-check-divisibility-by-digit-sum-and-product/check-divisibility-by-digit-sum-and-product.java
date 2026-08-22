class Solution {
    public boolean checkDivisibility(int n) {
        int temp = n;
        int sumDigit = 0;
        int prodDigit = 1;
        while(temp > 0){
            int digit = temp % 10;
            sumDigit += digit;
            prodDigit *= digit;
            temp /= 10;
        }
        int total = sumDigit + prodDigit;
        return n % total == 0;
    }
}