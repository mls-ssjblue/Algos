package ctci.dp;

import java.util.*;
import java.util.stream.Collectors;

public class AllSubsets {
    private static List<Set<Integer>> result;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 10, 0};
        List<List<Integer>> ans = allSubsets(nums);

    }

    private static List<List<Integer>> allSubsets(int[] nums) {
        result = new ArrayList<>();
        Set<Integer> a = new HashSet<>();
        subsetHelper(nums, a);
        List<List<Integer>> answer;
        answer = result.stream().map(ArrayList::new)
                .collect(Collectors.toList());
        return answer;

    }

    private static void subsetHelper(int[] nums, Set<Integer> currentSubset) {

        if (result.contains(currentSubset)) return;
        Set<Integer> subset = new HashSet<>(currentSubset);
        result.add(subset);

        if (currentSubset.size() == nums.length) return;

        for (int i = 0; i < nums.length; i++) {
            if (currentSubset.contains(nums[i])) continue;
            currentSubset.add(nums[i]);
            subsetHelper(nums, currentSubset);
            currentSubset.remove(nums[i]);
        }
    }
}
