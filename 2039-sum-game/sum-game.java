class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sumDiff = 0;
        int qDiff = 0;

        for(int i = 0; i < n; i++){
            char ch = num.charAt(i);
            boolean isLeft = i < n/2;

            if(ch == '?'){
                qDiff += isLeft ? 1 : -1;
            }else{
                int val = ch - '0';
                sumDiff += isLeft ? val : -val;
            }
        }
        return (qDiff % 2 != 0) || (sumDiff * 2 + qDiff * 9 != 0);
    }
}