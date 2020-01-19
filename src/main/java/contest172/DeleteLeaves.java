package contest172;

import org.junit.jupiter.api.Test;

public class DeleteLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {


        if(root.left!=null) root.left = removeLeafNodes(root.left,target);
        if(root.right!=null) root.right = removeLeafNodes(root.right,target);

        if(root.left == null && root.right == null && root.val == target) return null;
        return root;
    }
}
