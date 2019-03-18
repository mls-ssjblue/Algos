package permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {
    public static void main(String[] args) {

        int[] nums = {1, 1, 2};
        List<List<Integer>> answer = permuteUnique(nums);
        answer.forEach(perm -> System.out.println(perm.toString()));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null || nums.length==0) { return ans; }
        permute(ans, nums, 0);
        return ans;
    }

    private static void permute(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) { temp.add(num); }
            ans.add(temp);
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i=index; i<nums.length; ++i) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                permute(ans, nums, index+1);
                swap(nums, index, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }

}
