class Solution {
     public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at the
        // previous index whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            int value = num % k;

            // Subarrays ending at current index
            long[] newDp = new long[k];

            // Start a new subarray with only nums[i]
            newDp[value]++;

            // Extend all previous subarrays
            for (int r = 0; r < k; r++) {

                int newRemainder = (int) ((long) r * value % k);

                newDp[newRemainder] += dp[r];
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            // Move to next index
            dp = newDp;
        }

        return ans;
    }
}