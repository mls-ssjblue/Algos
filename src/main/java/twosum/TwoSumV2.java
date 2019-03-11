package twosum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumV2 {
    public static void main(String[] args) {
        int[] array = { 2,7,11,5 };
        int[] indices = twoSum(array, 9);
        System.out.println("RESULT!!:" + indices[0] + indices[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        
    }
}