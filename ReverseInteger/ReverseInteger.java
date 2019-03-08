
public class ReverseInteger {

    private static final int MAX_POSITIVE_INT_VAL = 2147483647;
    private static final int MAX_NEGATIVE_INT_VAL = -2147483648;

    public static void main(String[] args) {

        System.out.println(reverse(-312));

    }

    public static int reverse(int x) {

        int mag = Math.abs(x);
        int reversed = 0;
        int i = 0;
        while(mag > 0){
            int digit = mag % 10;
            if(reversed > MAX_POSITIVE_INT_VAL/10 ){
                return 0;
            }
            reversed = reversed * 10 +  digit;
            i++;
            mag/=10;
        }
        return reversed*((int)Math.signum(x));
        
    }

}