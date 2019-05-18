package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MinSteps {

    @Test
    public void test(){
        Assertions.assertEquals(3, minSteps(3));
    }

    public int minSteps(int n) {
        int ans = 0, d = 2;
        while (n > 1) {
            while (n % d == 0) {
                ans += d;
                n /= d;
            }
            d++;
        }
        return ans;
    }
}
