package dfs.balancedbinarytree;

import dfs.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,-1,-1,4,4};
        TreeNode tree = TreeNode.buildTree(arr, null, 0);
        System.out.println(isBalanced(tree));
    }

    private static boolean isBalanced(TreeNode root) {

        if(root == null) return true;
        boolean isBalanced = Math.abs(subTreeHeight(root.left) - subTreeHeight(root.right)) <= 1;
        return isBalanced &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private static int subTreeHeight(TreeNode root) {

        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return 1 + Math.max(subTreeHeight(root.left), subTreeHeight(root.right));
    }



}






