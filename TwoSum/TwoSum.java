import java.util.Arrays;
import java.util.Scanner;

public class TwoSum{
    public static void main(String[] args){
        int[] array = {1,3,4,2,7};
        int[] indices = twoSum(array, 10);
        System.out.println(indices[0] + indices[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        int[] indices = new int[2];
        for(int i = 0; i < nums.length ; i++){
            for(int j = i + 1; j < nums.length; j++){
                System.out.println( i + " " + j);
                if(nums[i] + nums[j] == target){
                    System.out.println(i + " " + j);                    
                    indices[0] = i; 
                    indices[1] = j;
                    break;
                }
            }
        }
        return indices;
    }
}