public class ReverseLinkedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
         l4.next = l5;
        ListNode result = reverseBetween(l1, 1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode prev = null, next;
        ListNode curr = head;
        ListNode first = null, second = null;
        int i = 1;
        while (curr != null) {
            next = curr.next;
            if (i < m) {
            }
            if (i == m) {
                second = curr;
                first = prev;

            } else if (i > m && i < n) {
                next = curr.next;
                curr.next = prev;
            }
            else if (i == n) {
                if (first != null) {
                    first.next = curr;
                }
                next = curr.next;
                second.next = next;
                curr.next = prev;
                if (m == 1) head = curr;

            }
            prev = curr;
            curr = next;
            i++;
        }

        return head;
    }
}
