package latest;

import org.junit.jupiter.api.Test;

public class InsertIntoBST {

    @Test
    public void test(){

        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        node4.left = node1;
        node4.right = node6;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3;
        node6.right = node7;
        node7.right = node8;
        insertIntoBST(node4,5);
    }

    public TreeNode insertIntoBST(TreeNode root, int val){
            if(root == null) return new TreeNode(val);
            if(val >= root.val) {

                if(root.right == null)root.right = new TreeNode(val);
                else insertIntoBST(root.right, val);
            }
            else {
                if(root.left == null) root.left = new TreeNode(val);
                else insertIntoBST(root.left, val);
            }
            return root;
    }
}
