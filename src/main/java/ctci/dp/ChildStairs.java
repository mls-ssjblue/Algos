package ctci.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChildStairs {

    @Test
    public void test(){
        Assertions.assertEquals(4, numWaysToClimb(3));
    }

    private int numWaysToClimb(int steps) {
        int [] numWays = new int[10000];
        numWays[0] = 1;
        numWays[1] = 2;
        numWays[2] = 4;
        for(int i = 0; i< steps-3;i++){
            numWays[i+3] = numWays[i+2] + numWays[i+1] + numWays[i];
        }
        return numWays[steps-1];

    }
}
