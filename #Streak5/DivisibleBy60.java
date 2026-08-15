import java.util.*;
public class DivisibleBy60 {
    public int divisibleBy60(ArrayList<Integer> A) {
        if(A.size() == 1 && A.get(0) ==  0){
            return 1;
        }
        int sum = 0;
        boolean hasZero = false;
        int evenCount = 0;
        
        for(int digit : A){
            sum += digit;
            if(digit == 0) hasZero = true;
            if(digit % 2 == 0) evenCount++;
        }
        if(hasZero && (sum % 3 == 0) && evenCount >= 2){
            return 1;
        }
        return 0;
    }
}
