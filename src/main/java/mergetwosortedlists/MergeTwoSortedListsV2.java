package mergetwosortedlists;

public class MergeTwoSortedListsV2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(9);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        ListNode p3 = mergeTwoLists(l1, l2);
        while(p3!=null){
            System.out.println(p3.val);
            p3 = p3.next;
        }
    }

    public static  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
