public class verifyPrime {
    public int isPrime(int num){
        for(int i = 1; i <= num; i++){
            if(num % i == 0){
                return 0;
            }
        }
        return 1;
    }
    public int isPrime2(int num){
        if(num <= 1){
            return 0;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return 0;
            }
        }
        return 1;
    }
}