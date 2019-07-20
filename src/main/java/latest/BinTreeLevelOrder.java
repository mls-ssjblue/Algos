package latest;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BinTreeLevelOrder {
    @Test
    public void test(){

        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7  = new TreeNode(7);
        root.left = node9;
        root.right = node20;
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(9,20));
        expected.add(Arrays.asList(15,7));
        Assertions.assertEquals(expected, levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for(int i = 0; i< levelSize; i ++) {
                TreeNode node = queue.remove();
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
                level.add(node.val);
            }
            result.add(level);
        }
        return  result;
    }
}
