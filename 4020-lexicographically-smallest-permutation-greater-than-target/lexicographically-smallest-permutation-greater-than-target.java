class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        char[] result = new char[n];
        if (backtrack(0, false, count, target, result)) {
            return new String(result);
        }
        return "";
    }

    private boolean backtrack(int index, boolean isGreater, int[] count, String target, char[] result) {
        if (index == target.length()) {
            return isGreater; // Must be strictly greater
        }

        int startChar = isGreater ? 0 : (target.charAt(index) - 'a');

        for (int c = startChar; c < 26; c++) {
            if (count[c] == 0) continue;

            boolean nextIsGreater = isGreater || (c > target.charAt(index) - 'a');
            
            // Try using this character
            count[c]--;
            result[index] = (char) ('a' + c);

            if (backtrack(index + 1, nextIsGreater, count, target, result)) {
                return true;
            }

            // Backtrack
            count[c]++;
        }

        return false;
    }
}