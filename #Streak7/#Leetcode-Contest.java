class problem1 {
    public int nearestDrone(int[][] drones, int[] target) {
        int bestIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        int tx = target[0];
        int ty = target[1];

        for (int i = 0; i < drones.length; i++) {
            int x = drones[i][0];
            int y = drones[i][1];
            int range = drones[i][2];

            // Manhattan Distance Formula: |x1 - x2| + |y1 - y2|
            int distance = Math.abs(x - tx) + Math.abs(y - ty);

            // Check if within range and strictly closer than the previous best drone
            if (distance <= range && distance < minDistance) {
                minDistance = distance;
                bestIndex = i;
            }
        }

        return bestIndex;
    }
}