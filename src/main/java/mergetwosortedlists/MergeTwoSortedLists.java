package mergetwosortedlists;

public class MergeTwoSortedLists {
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
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else {
            ListNode p3 = new ListNode(0);
            ListNode tmp = p3;
            while (l1 != null || l2 != null) {
                tmp.next = new ListNode(0);

                if(l1 == null){
                    tmp.val = l2.val;
                    l2 = l2.next;
                    tmp = tmp.next;
                    continue;
                }

                else if (l2 == null || (l1.val <= l2.val)) {
                    tmp.val = l1.val;
                    tmp = tmp.next;
                    l1 = l1.next;
                } else {
                    tmp.val = l2.val;
                    tmp = tmp.next;
                    l2 = l2.next;
                }

            }
             tmp = p3;
            while(tmp!=null){
                if(tmp.next.next == null){
                    tmp.next = null;
                    break;
                }
                tmp = tmp.next;
            }
            return p3;

        }
    }
}
