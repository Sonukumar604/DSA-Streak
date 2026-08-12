
public class StepByStep {
    public int solve(int A) {
        A = Math.abs(A);
        int sum = 0;
        int moves = 0;
        while(sum < A || (sum - A) % 2 != 0){
            moves++;
            sum += moves;
        }
        return moves;
    }
}
