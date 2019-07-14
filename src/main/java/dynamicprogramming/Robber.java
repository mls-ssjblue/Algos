package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Robber {

    @Test
    public void test() {
        int [] nums = {1,2,3,1};
        Assertions.assertEquals(4, rob(nums));
    }

    public static int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
//            System.out.println(n + ":" + prevNo + ":" +  prevYes);
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
            System.out.println(n + ":" + prevNo + ":" +  prevYes);
        }
        return Math.max(prevNo, prevYes);
    }
}
