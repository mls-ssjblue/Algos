package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

    @Test
    public void test() {

        Assertions.assertEquals(2, firstMissingPositive(new int[]{3,4,-1,1}));
    }
//[2147483647]
    private int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        Map<Integer, Boolean> vals = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                vals.put(nums[i], true);
        }

        int max = Arrays.stream(nums).max().getAsInt();
        if(max < 0)return 1;
        for (int i = 1; i <= max; i++) {
            if (!vals.containsKey(i)) return i;
        }
        return max+1;
    }
}
