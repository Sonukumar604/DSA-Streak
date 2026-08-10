import java.util.*;
public class AllFactors {
    public ArrayList<Integer> allFactors(int A) {
        ArrayList<Integer> res = new ArrayList<>();
        int sqrt = (int) Math.sqrt(A);
        for(int num = 1; num <= sqrt; num++){
            if(A % num ==  0){
                res.add(num);
                if(num != A/num){
                    res.add(A/num);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
