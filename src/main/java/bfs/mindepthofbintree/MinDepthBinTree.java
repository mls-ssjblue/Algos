package bfs.mindepthofbintree;

import dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepthBinTree {
    public static void main(String[] args) {
        int[] arr = {3,9,20,-1,-1,15,7};
        TreeNode tree = TreeNode.buildTree(arr, null, 0);
        System.out.println(minDepth(tree));
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> nodesToVisit = new LinkedList<>();
        if(root.left == null && root.right == null) return 1;
        if (root.left != null) nodesToVisit.add(root.left);
        if (root.right != null) nodesToVisit.add(root.right);
        int minHeightOfSubTrees = Integer.MAX_VALUE;
        while(!nodesToVisit.isEmpty()){
            TreeNode curr = nodesToVisit.remove();
            int minDepthOfCurr = minDepth(curr);
            minHeightOfSubTrees = minDepthOfCurr < minHeightOfSubTrees? minDepthOfCurr : minHeightOfSubTrees;
        }
        return 1 + minHeightOfSubTrees;
    }
}
