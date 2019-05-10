package dynamicprogramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClimbingStairs {

    private static int[] steps = new int[1000];

    @Test
    public void test(){
        Assertions.assertEquals(3,climbStairs(3));
    }

    public static int climbStairs(int n){

        if(n==1) return 1;
        else if(n==2) return 2;
        if(steps[n] > 0) return steps[n];
        steps[n]  = climbStairs(n-1) + climbStairs(n-2);
        return steps[n];
    }
}
