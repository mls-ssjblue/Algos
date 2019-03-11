import java.util.*;


public class ThreeSum {
    public static void main(String [] args){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> answers = threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> answers = new ArrayList<>();
        Map<Integer,List<Integer>> complementMap = getComplementMap(nums);
        for(int i =0;i<nums.length;i++){
            List<Integer> complements = complementMap.get(nums[i]*-1);
            if(!complements.isEmpty()){
                List<Integer> validResult = Arrays.asList( Integer.valueOf(nums[i]));
                validResult.addAll(complements);
                answers.add(validResult);f
            }
        }
        System.out.println(answers);
        
        return null;
    }
   fvdfg

    private static Map<Integer, List<Integer>> getComplementMap(int[] nums){

        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<List<Integer>>> a = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                map.put(Integer.valueOf(nums[i] + nums[j]), Arrays.asList(nums[i],nums[j]));
            }
        }
        System.out.println(map.toString());
        return map;
        
    }
}