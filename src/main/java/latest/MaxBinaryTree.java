package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class MaxBinaryTree {
    @Test
    public void test() {

        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        node6.left = node3;
        node6.right = node5;
        node3.right = node2;
        node5.left = node0;
        node2.right = node1;

        int[] nums = {3, 2, 1, 6, 0, 5};

        Assertions.assertEquals(node6.val, constructMaximumBinaryTree(nums).val);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        int[] leftNums, rightNums;
        leftNums = Arrays.copyOfRange(nums,0,maxIndex);
        rightNums = Arrays.copyOfRange(nums,maxIndex + 1, nums.length);

        TreeNode res = new TreeNode(nums[maxIndex]);
        res.left = constructMaximumBinaryTree(leftNums);
        res.right = constructMaximumBinaryTree(rightNums);
        return res;
    }
}
