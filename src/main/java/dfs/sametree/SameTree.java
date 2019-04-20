package dfs.sametree;

import dfs.TreeNode;

import static dfs.TreeNode.buildTree;

public class SameTree {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        TreeNode node1 = buildTree(arr1, null, 0);
        TreeNode node2 = buildTree(arr2, null, 0);
        System.out.println(isSameTree(node1, node2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);

    }



}

