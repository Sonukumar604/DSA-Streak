
public class BishopMoves {
    public int solve(int A, int B) {
        int topLeft = Math.min(A-1, B-1);
        int topRight = Math.min(A-1, 8-B);
        int bottomLeft = Math.min(8-A, B-1);
        int bottomRight = Math.min(8-A, 8-B);
        return topLeft + topRight + bottomLeft + bottomRight;
    }
}
