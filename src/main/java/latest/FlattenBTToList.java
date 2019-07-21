package latest;

public class FlattenBTToList {
    private static TreeNode prev = null;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        TreeNode node6 = new TreeNode(6);
        node5.right = node6;
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
