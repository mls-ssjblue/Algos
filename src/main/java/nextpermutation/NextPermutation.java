//package nextpermutation;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class NextPermutation {
//    public static void main(String[] args) {
//        int[] nums = {1,3,2};
//        nextPermutation(nums);
//    }
//
//    public static void nextPermutation(int[] nums) {
//
//        if(nums.length == 0 || nums.length == 1) return;
//        int i = nums.length - 1;
//        int flag = 0;
//        int j = i-1;
//        while (i > 0) {
//
//
//                if (nums[i-1] < nums[i]) {
//                    int j = i-1;
//
//                                        int temp = nums[i-1];
//                    nums[i-1] = nums[i];
//                    nums[i] = temp;
//                    int b[] = new int[nums.length - i];
//
//                    System.arraycopy(nums, i, b, 0, nums.length - i);
//                    int sorted[] = sort(b);
//                    System.arraycopy(sorted, 0, nums, i, nums.length - i);
//                    flag = 1;
//                    break;
//                }
//
//
//            }
//            i--;
//
//        }
////        if (flag == 0) {
////           nums = sort(nums);
////        }
////        for (int k = 0; k < nums.length; k++)
////            System.out.print(nums[k] + " ");
//    }
//
//    public static int[] sort(int[] vals) {
//        List<Integer> ints = Arrays.stream(vals).boxed().collect(Collectors.toList());
////        return ints.stream().sorted().mapToInt(i -> i).toArray();
//return null;
//    }
//}
//