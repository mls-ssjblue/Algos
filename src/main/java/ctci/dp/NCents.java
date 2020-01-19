package ctci.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class NCents {

    int count = 0;

    List<List<Integer>> usedCombinations = new ArrayList<>();

    @Test
    public void test() {
        Assertions.assertEquals(4, numWays(500, new int[]{1, 2, 5}));
    }

    private int numWays(int sum, int[] denom) {
        HashSet a = new HashSet();
        boolean[] used = new boolean[3];

        numWaysHelper(sum, denom, new ArrayList<>(), used);
        return count;
    }

    private void numWaysHelper(int sum, int[] denom, List<Integer> current, boolean[] used) {
        List<Integer> temp = new ArrayList<>(current);
        Collections.sort(temp);
        if (sum == 0 && !usedCombinations.contains(temp)) {
            usedCombinations.add(temp);
            count++;
            return;
        }
        if (sum < 0) return;
        for (int i = 0; i < denom.length; i++) {
            sum -= denom[i];
            current.add(denom[i]);

            numWaysHelper(sum, denom, current, used);

            sum += denom[i];
            current.remove(current.size()-1);
        }
    }
}
