package bfs.bintreelevelorder;

import dfs.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinTreeLevelOrderTraversal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, -1, -1, 4, 4};
        TreeNode tree = TreeNode.buildTree(arr, null, 0);

//        Iterator iterator = levelOrder2(tree).iterator();
//        while (iterator.hasNext()) {
//            List<Integer> level = (LinkedList<Integer>) iterator.next();
//            for (Integer i : level) {
//                System.out.println(i);
//            }
//        }
        List<List<Integer>> res = levelOrder2(tree);
        res.forEach(list->{
            list.forEach(item->System.out.print(item));
            System.out.println();
        });
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<List<TreeNode>> toVisit = new LinkedList<>();
        if (root.right == null && root.left == null) levelOrder.add(Collections.singletonList(root.val));
        List<TreeNode> levelNodes = new ArrayList<>();

        if (root.left != null) levelNodes.add(root.left);
        if (root.right != null) levelNodes.add(root.right);

        toVisit.add(levelNodes);

        while (!toVisit.isEmpty()) {
            levelOrder.add(toVisit.peek()
                    .stream()
                    .map(node -> node.val)
                    .collect(Collectors.toList()));
            levelNodes = new ArrayList<>();
            for (TreeNode levelNode : toVisit.remove()) {
                levelNodes.add(levelNode);
            }
//            levelVals.add(root.val);


        }
        return levelOrder;
    }

    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> toVisit = new LinkedList<>();
        TreeNode current = root;
        toVisit.add(current);
        List<List<Integer>> res = new ArrayList<>();
        int count = 1;
        List<Integer> l = new ArrayList(root.val);
        res.add(l);

        while(!toVisit.isEmpty()){
            current = toVisit.remove();
            if(current.left != null) {toVisit.add(current.left);}
            if(current.right != null) {toVisit.add(current.right);}
            count+=2;
            if(isPowerOfTwo(count+1) ){
                l = toVisit.stream().map(node->node.val).collect(Collectors.toList());
                res.add(l);
            }
        }
        return res;
    }
    public static boolean isPowerOfTwo(int n) {
        return n>0 && n==Math.pow(2, Math.round(Math.log(n)/Math.log(2)));
    }
}
