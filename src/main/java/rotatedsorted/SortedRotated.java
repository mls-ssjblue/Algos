package rotatedsorted;

public class SortedRotated {

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,8,1,2};
        int ans = search(nums, 8);
        System.out.println(ans);
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] != target) return -1;
        if (nums[nums.length - 1] > nums[0]) return findVal(nums, 0, nums.length - 1, target);
        int highIndex = findHigh(nums, 0, nums.length - 1);
        if (target > nums[highIndex]) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        if(target == nums[0]) return 0;
        if (target > nums[0]) return findVal(nums, 0, highIndex, target);
        else return findVal(nums, highIndex + 1, nums.length - 1, target);
    }

    public static int findVal(int[] arr, int start, int end, int val) {
        if (end >= start) {
            int mid = (start + end) / 2;
            if (arr[mid] == val) return mid;
            if (val > arr[mid]) {
                return findVal(arr, mid + 1, end, val);
            } else
                return findVal(arr, start, mid -1, val);
        }
        return -1;
    }

    public static int findHigh(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] == arr[start]) return mid;
        else if (arr[mid] > arr[start]) {
            return findHigh(arr, mid, end);
        } else
            return findHigh(arr, start , mid );
    }
}
