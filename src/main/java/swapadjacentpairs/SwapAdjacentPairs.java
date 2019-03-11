public class SwapAdjacentPairs {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode res = swapPairs(l1);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node = head;
        ListNode newHead = head.next;
        while(isNextSwapPresent(node)){
            swapAdjacentPair(node);
            ListNode nextNode  = node.next;
            if(isNextSwapPresent(nextNode))
                node.next = nextNode.next;
            node = nextNode;
        }

        node = newHead;
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
        return newHead;
    }

    private static boolean isNextSwapPresent(ListNode node) {
        return node != null && node.next != null;
    }

    private static void swapAdjacentPair(ListNode node) {

        ListNode temp = node.next.next;
        node.next.next = node;
        node.next =  temp;
    }
}
