import java.util.*;
import java.util.stream.Collectors;


public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> answers = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        Map<Integer, List<List<Integer>>> complementMap = getComplementMap(nums);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> complementCombos = complementMap.get(nums[i] * -1);
            if (complementCombos != null) {
                List<Integer> validResult = new ArrayList<>();
                Integer e = Integer.valueOf(nums[i]);
                validResult.add(e);
                int finalI = i;
                List<List<Integer>> validCombos = complementCombos.stream()
                        .filter(combo -> combo.stream().filter(index -> index == finalI).collect(Collectors.toList()).size() == 0)
                        .collect(Collectors.toList());
                if (validCombos.size() > 0) {
                    int finalI1 = i;
                    List<List<Integer>> finalCombos = new ArrayList<>();
                    validCombos.forEach(combo -> {
                        List<Integer> temp = combo.stream()
                                .map(index->Integer.valueOf(nums[index]))
                                .collect(Collectors.toList());
                       temp.add(nums[finalI1]);
                       finalCombos.add(temp);
                   });
                    finalCombos.forEach(combo->answers.add(combo));

                }
            }
        }

        List<List<Integer>> distinctAnswers = answers.stream()
                .map(list-> list.stream().sorted().collect(Collectors.toList()))
                .distinct().collect(Collectors.toList());
        System.out.println(distinctAnswers);

        return distinctAnswers;
    }

    private static Map<Integer, List<List<Integer>>> getComplementMap(int[] nums) {

        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<List<Integer>> combos = Optional.ofNullable(map.get(nums[i] + nums[j]))
                        .orElse(new ArrayList<>());
                combos.add(Arrays.asList(i, j));
                map.put(nums[i] + nums[j], combos);
            }
        }
        System.out.println(map);
        return map;

    }
}