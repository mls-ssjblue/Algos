package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.*;

public class JumpGame {

//    Map<Integer, Boolean> memo = new HashMap<>();
    boolean[] memo = new boolean[100000];
    @Test
    public void test() throws FileNotFoundException {
        int[] nums = {2, 3, 1, 1, 4};
        Assertions.assertEquals(true, canJump(nums));
        int[] nums2 = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};

        Assertions.assertEquals(true, canJump(nums2));
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[]nums, int index){
        if (nums.length == 0 || nums.length == 1) return true;
        int i;

        if(memo[index]) return memo[index];
        for (int j = 0; j < nums[0] && j < nums.length; j++) {
            int[] subArray = Arrays.copyOfRange(nums, j + 1, nums.length);
            boolean res = canJump(subArray, index + j);
            memo[index]= res;
            if(res) {
                return true;
            }
        }
        return false;
    }

    public boolean canJumpBest(int[] nums){
        int n = nums.length;
        int last=n-1,i,j;
        for(i=n-2;i>=0;i--){
            if(i+nums[i]>=last)last=i;
        }
        return last<=0;
    }
}
