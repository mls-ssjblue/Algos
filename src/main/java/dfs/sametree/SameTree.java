package dfs.sametree;

import dfs.TreeNode;

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

    private static TreeNode buildTree(int[] arr, TreeNode root, int i) {

        if (i < arr.length) {
            if (arr[i] == -1) return null;
            root = new TreeNode(arr[i]);
            root.left = buildTree(arr, root.left, 2 * i + 1);
            root.right = buildTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }


}

