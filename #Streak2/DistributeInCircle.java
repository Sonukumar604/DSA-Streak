
public class DistributeInCircle {
    public int solve(int A, int B, int C) {
        int lastPosition = (C + A - 1) % B;
        
        // If modulo is 0, it means it lands on the last position (B)
        if (lastPosition == 0) {
            return B;
        }
        
        return lastPosition;
    }
    public int solve1(int A, int B, int C) {
        // Formula: ((C + A - 2) % B) + 1
        return ((C + A - 2) % B) + 1;
    }
}
