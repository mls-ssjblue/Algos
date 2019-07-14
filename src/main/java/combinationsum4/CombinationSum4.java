package combinationsum4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum(nums,4));
    }

    public static int combinationSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();

        result = combinations(nums,null, result, target);
        return result.size();
    }

    public static List<List<Integer>> combinations(int[] nums, List<Integer> combination, List<List<Integer>> res, int target){

        if(combination==null) combination= new ArrayList<>();
        int sum = combination.stream().mapToInt(Integer::intValue).sum();
        if(sum == target){
            res.add(combination);
            return res;
        }
        else if(sum > target) return res;

        int i =0;
        while(i<nums.length){
            combination.add(Integer.valueOf(nums[i]));
            combinations(nums, combination, res, target);
            combination.remove(Integer.valueOf(nums[i]));
            i++;
        }
        return res;
    }
}
