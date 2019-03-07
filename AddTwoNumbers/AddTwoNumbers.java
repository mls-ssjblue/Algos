class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public static void main(String[] args) {
        System.out.println("hello");

        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(8);
        // ListNode l3 = new ListNode(5);
        l1.next = l2;
        // l2.next = l3;
        ListNode l4 = new ListNode(1);
        // ListNode l5 = new ListNode(4);
        // ListNode l6 = new ListNode(2);
        // l4.next = l5;
        // l5.next = l6;
        ListNode sum = answer(l1, l4);
       System.out.println(sum.val + " " + sum.next.val );

    }

    public static ListNode answer(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(0);
        ListNode tmp = answer, p = l1, q = l2;
        int carry = 0;
        while (p!=null || q!= null) {   
             int x = p != null? p.val : 0;
            int y = q != null? q.val : 0;
            int sumDigit = x + y + carry;
            carry = sumDigit /10;
            tmp.next = new ListNode(sumDigit % 10);    
            tmp = tmp.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;

        }       
       
        if (carry > 0) {
            tmp.next = new ListNode(carry);
        }

        return answer.next;
    }

    private static ListNode insertIntoAnswer(int sumDigit, ListNode answer) {

        ListNode newDigit = new ListNode(sumDigit);
        answer.next = newDigit;
        return newDigit;
    }

    private static int getLength(ListNode tmp) {
        int len = 0;
        while (tmp.next != null) {
            tmp = tmp.next;
            len++;
        }
        return len + 1;
    }
}
