package misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    @Test
    public void test() {

        Assertions.assertEquals(3,
                canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Assertions.assertEquals(-1,
                canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
        Assertions.assertEquals(-1,
                canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4}));
        Assertions.assertEquals(4,
                canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
    }

    private int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0;
        int tank = gas[0];
        int N = gas.length;
        int distance = 0;
        List<Integer> startIndicesUsed = new ArrayList<>();
        for(int i = 0; i < N; i ++ ) {
            if(distance == N) return startIndex;
            if(tank < cost[i]){
                if(startIndicesUsed.size() == N || startIndex==N-1) return -1;
                startIndex++;
                i= startIndex-1;
                distance = 0;
                startIndicesUsed.add(startIndex);
                tank = gas[startIndex];
            }
            else{
                tank += (i!=N-1) ? gas[i + 1] - cost[i]: gas[0] - cost[N-1];
                if(i == N-1) i = -1;
                distance ++;
            }

        }
        return startIndex;

    }
}
