
public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int result = 0;
        for(int i = 0; i < A.length(); i++){
            char c = A.charAt(i);
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}
