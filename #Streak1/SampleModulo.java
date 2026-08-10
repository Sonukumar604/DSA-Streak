public class SampleModulo {
    public int solve(int A, int B){
        int MOD = 10000000;
        Long sum = (long) A + B;
        return (int) (sum % MOD);
    }
}