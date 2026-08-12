
public class IsRectangle {
    public int solve(int A, int B, int C, int D) {
        // Option 1: A matches B, so C must match D
        // Option 2: A matches C, so B must match D
        // Option 3: A matches D, so B must match C
        if ((A == B && C == D) || (A == C && B == D) || (A == D && B == C)) {
            return 1;
        }
        
        return 0;
    }
}
