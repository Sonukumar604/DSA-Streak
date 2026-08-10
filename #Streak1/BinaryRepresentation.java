
public class BinaryRepresentation {
    public String findDigitsInBinary(int A){
        String binary = "";
        if(A == 0){
            return "0";
        }
        while(A != 0){
            int dig = A % 2;
            binary = (dig == 1 ? "1" : "0") + binary;
            A = A / 2;
        }
        return binary;
    }
}
