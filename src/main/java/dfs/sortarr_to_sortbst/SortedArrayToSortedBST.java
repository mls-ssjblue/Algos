package dfs.sortarr_to_sortbst;

import dfs.TreeNode;

public class SortedArrayToSortedBST {
    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        printBT((sortedArrayToBST(arr, 0, arr.length-1)));
    }

    private static void printBT(TreeNode bt) {

        if(bt == null) return;
        System.out.println(bt.val);
        printBT(bt.left);
        printBT(bt.right);
    }

    public static TreeNode sortedArrayToBST(int[] arr, int start, int end) {

        /* Base Case */
        if (start > end) {
            return null;
        }

        /* Get the middle element and make it root */
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        /* Recursively construct the left subtree and make it
         left child of root */
        node.left = sortedArrayToBST(arr, start, mid - 1);

        /* Recursively construct the right subtree and make it
         right child of root */
        node.right = sortedArrayToBST(arr, mid + 1, end);

        return node;
    }
}
