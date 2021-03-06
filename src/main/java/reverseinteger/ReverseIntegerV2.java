package reverseinteger;

public class ReverseIntegerV2 {

    private static final int MAX_POSITIVE_INT_VAL = 2147483647;
    private static final int MAX_NEGATIVE_INT_VAL = -2147483648;

    public static void main(String[] args) {

        System.out.println(reverse(-319));

    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

}