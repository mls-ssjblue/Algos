package dfs;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static TreeNode buildTree(int[] arr, TreeNode root, int i) {

        if (i < arr.length) {
            if (arr[i] == -1) return null;
            root = new TreeNode(arr[i]);
            root.left = buildTree(arr, root.left, 2 * i + 1);
            root.right = buildTree(arr, root.right, 2 * i + 2);
        }
        return root;
    }
}