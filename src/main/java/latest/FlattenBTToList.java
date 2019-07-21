package latest;

public class FlattenBTToList {
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

    public static void flatten(TreeNode root){
        flattenHelper(root);
    }
    public static TreeNode flattenHelper(TreeNode root){
        if(root == null) return null;
        TreeNode leftRes = flattenHelper(root.left);
        TreeNode rightRes = flattenHelper(root.right);
        if(leftRes == null) {
            root.right = rightRes;
        }
        else {
            root.right = leftRes;
            root.left = null;
            TreeNode tmp = leftRes;
            while(tmp.right!=null) tmp = tmp.right;
            tmp.right = rightRes;
        }
        return root;
    }
}
