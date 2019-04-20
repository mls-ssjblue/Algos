package dfs.symmetrictree;

import dfs.TreeNode;

public class SymmetricTree {

    public static void main(String[] args) {
        int[] arr = {1,2,2,-1,3,-1,3};
        TreeNode tree = TreeNode.buildTree(arr,null, 0);
        System.out.println(isSymmetric (tree));
    }

    public static boolean isSymmetric(TreeNode root) {

        if(root == null) return true;
        return areSubTreesSymmetric(root.left, root.right);

    }
    public static boolean areSubTreesSymmetric(TreeNode p, TreeNode q){

        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q .val) return false;
        return areSubTreesSymmetric(p.left, q.right) &&
                areSubTreesSymmetric(p.right, q.left);
    }
}
