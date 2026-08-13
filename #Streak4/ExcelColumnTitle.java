
public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        StringBuilder sb = new StringBuilder();
        while(A > 0){
            A--;
            int rem = A % 26;
            char c = (char) ('A' + rem);
            sb.append(c);
            A /= 26;
        }
        return sb.reverse().toString();
    }
}
