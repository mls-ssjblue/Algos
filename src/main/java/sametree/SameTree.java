package sametree;

public class SameTree {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3,  4};
        int[] arr2 = {1, 2, 3 ,4};
        TreeNode node1 = buildTree(arr1, null, 0);
        TreeNode node2 = buildTree(arr2, null, 0);
        System.out.println(isSameNode(node1, node2));
    }

    public static boolean isSameNode(TreeNode p, TreeNode q) {

        boolean left = true,right = true ,self=true;
        if(p == null || q == null ){
            if(p== null && q == null) return true;
            else return false;
        }
        if (isNodeDifferent(p, q, "L")) left = false;
        if (isNodeNotNull(p, q, "L")) {
            left = isSameNode(p.left, q.left);
        }
        if (p.val != q.val) self = false;
        if (isNodeDifferent(p, q, "R")) right = false;
        if (isNodeNotNull(p, q, "R")) {
            right = isSameNode(p.right, q.right);
        }
        return left  && right && self;
    }

    private static boolean isNodeNotNull(TreeNode p, TreeNode q, String node) {
        return node.equals("R") ? p.right != null && q.right != null : p.left != null && q.left != null;
    }

    private static boolean isNodeDifferent(TreeNode p, TreeNode q, String node) {
        return node.equals("R") ? p.right == null && q.right != null || p.right != null && q.right == null :
                p.left == null && q.left != null || p.left != null && q.left == null;
    }


    private static TreeNode buildTree(int[] arr, TreeNode root, int i) {

        if (i < arr.length) {
            if(arr[i] == -1) return null;
            root = new TreeNode(arr[i]);
            root.left = buildTree(arr, root.left, 2 * i + 1);
            root.right = buildTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}