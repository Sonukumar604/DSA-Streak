class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int left = 0;
        int countOnes = 0;
        String ans = "";
        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '1') {
                countOnes++;
            }
            while (countOnes == k) {
                String current = s.substring(left, right + 1);
                if (ans.isEmpty() || current.length() < ans.length() || 
                   (current.length() == ans.length() && current.compareTo(ans) < 0)) {
                    ans = current;
                }
                if (s.charAt(left) == '1') {
                    countOnes--;
                }
                left++;
            }
        }
        return ans;
    }
}