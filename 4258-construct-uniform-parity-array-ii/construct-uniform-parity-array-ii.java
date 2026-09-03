class Solution {
    public boolean uniformArray(int[] nums1) {
        
        int minEven = Integer.MAX_VALUE, minOdd = Integer.MAX_VALUE;
        for (int v : nums1) {
            if (v % 2 == 0) minEven = Math.min(minEven, v);
            else minOdd = Math.min(minOdd, v);
        }
        return canAchieve(nums1, 0, minEven, minOdd) || canAchieve(nums1, 1, minEven, minOdd);
    }

    private boolean canAchieve(int[] nums1, int target, int minEven, int minOdd) {
        for (int v : nums1) {
            if (v % 2 == target) continue; 
            int neededParity = (v % 2) ^ target;
            int neededMin = (neededParity == 0) ? minEven : minOdd;

            if (neededMin < v) continue; 
            return false; 
        }
        return true;
    }
}