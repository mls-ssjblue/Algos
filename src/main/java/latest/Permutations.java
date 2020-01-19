package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    List<List<Integer>> permutations = new ArrayList<>();

    boolean[]chosen = new boolean[1000];
    @Test
    public void test() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        );

        int[] nums = {1, 2, 3};
        Assertions.assertEquals(expected, permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> empty = new ArrayList<>();
        permuteHelper(nums, empty);
        return permutations;
    }

    private void permuteHelper(int[] nums, List<Integer> current) {
        if(current.size() == nums.length){
            List<Integer> permutation = new ArrayList<>(current);
            permutations.add(permutation);
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(chosen[i]) continue;
            chosen[i] = true;
            current.add(nums[i]);
            permuteHelper(nums, current);
            current.remove(current.size()-1);
            chosen[i]=false;
        }
    }


}
