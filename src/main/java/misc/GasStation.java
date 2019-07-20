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
                canCompleteCircuit(new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1}));
    }

    private int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank = tank + gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }

        return (total + tank < 0) ? -1 : start;

    }
}
