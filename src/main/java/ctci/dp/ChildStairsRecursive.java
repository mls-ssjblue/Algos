package ctci.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChildStairsRecursive {

    @Test
    public void test(){
        Assertions.assertEquals(4, numWaysToClimb(3));
    }

    public int numWaysToClimb(int steps){
        int[] map = new int[steps];
        return numWaysToClimbRecDp(steps, map);
    }
    private int numWaysToClimbRecDp(int steps, int[] map) {
        if(steps > 0 && map[steps-1]!=0) return map[steps-1];
        if(steps < 0) return 0;
        if (steps==0) return 1;
        map[steps-1] = numWaysToClimbRecDp(steps-1,map) + numWaysToClimbRecDp(steps-2,map) + numWaysToClimbRecDp(steps-3,map);
        return map[steps-1];
    }

    private int numWaysToClimbRec(int steps) {
        if(steps<0) return 0;
        if(steps==0) return 1;
        return numWaysToClimbRec(steps-1) + numWaysToClimbRec(steps-2) + numWaysToClimbRec(steps-3);
    }
}
