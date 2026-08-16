import java.util.Arrays;

public class Problem2 {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = arrivalTime.length;
        int m = lights.length;

        // Sort light offsets in ascending order
        Arrays.sort(lights);

        int maxWait = 0;

        for (int arrival : arrivalTime) {
            int r = arrival % period;

            // Find the smallest light offset L_j > r using binary search
            // If such L_j exists, wait time is 0.
            // Otherwise, wait time is (period - r).
            int idx = upperBound(lights, r);

            if (idx < m) {
                // We can assign to a light where L_j > r, wait time = 0
                maxWait = Math.max(maxWait, 0);
            } else {
                // No light has L_j > r, wait time = period - r
                maxWait = Math.max(maxWait, period - r);
            }
        }

        return maxWait;
    }

    // Helper method to find upper bound (first element > key)
    private int upperBound(int[] arr, int key) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
