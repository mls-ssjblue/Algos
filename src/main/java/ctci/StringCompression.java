package ctci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabcccaaaadd"));
    }

    @Test
    public void test(){
        Assertions.assertEquals("a2b1c3a4d1", compress("aabcccaaaad"));
        Assertions.assertEquals("a1b5c1", compress("abbbbbc"));
    }

    public static String compress(String input) {
        int[] count = new int[128];
        String output="";
        char last = input.charAt(0);
        for (int i = 0; i < input.length(); i++) {
            count[input.charAt(i)]++;
            if (input.charAt(i) != last || (input.charAt(i) == last && i == input.length()-1)) {
                output += "" + last + count[last];
                count[last] = 0;
                last = input.charAt(i);
            }
             if ( i == input.length()-1 && input.charAt(i) != input.charAt(i-1) ){
                output += "" + input.charAt(i) + "1";
            }
        }
        if(output.length() >= input.length()) return input;
        return output;
    }
}
