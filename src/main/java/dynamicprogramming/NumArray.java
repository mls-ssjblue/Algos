package dynamicprogramming;

import org.junit.jupiter.api.Test;

public class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }    }

    @Test
    public void test(){

    }

    public int sumRange(int i, int j){
        return sum[j + 1] - sum[i];

    }

}
