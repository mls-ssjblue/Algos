package latest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinSearchTreeToGreaterSumTree {
    int pre = 0;

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
        node6.left= node5;
        node6.right = node7;
        node7.right = node8;

        int[] nums = {3, 2, 1, 6, 0, 5};

        bstToGst(node4);
    }

    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }


}

