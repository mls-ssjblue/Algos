package dfs.sumroottoleafnumbers;

import dfs.TreeNode;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        int[] arr = {4, 9, 0, 5, 1};
        TreeNode tree = TreeNode.buildTree(arr, null, 0);
        System.out.println(sumNumbers(tree));
    }

    public static int sumNumbers(TreeNode root) {

        return sum(root, 0);
    }

    public static int sum(TreeNode root, int num) {

        if (root == null) {
            return 0;
        }

        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            return num;
        }
        return sum(root.left, num) + sum(root.right, num);

    }
}
