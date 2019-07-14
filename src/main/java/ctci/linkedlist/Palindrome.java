package ctci.linkedlist;

public class Palindrome {

    public static void main(String[] args) {

        LinkedListNode node1 = new LinkedListNode("a");
        LinkedListNode node2 = new LinkedListNode("b");
        LinkedListNode node3 = new LinkedListNode("c");
        LinkedListNode node4 = new LinkedListNode("c");
        LinkedListNode node5 = new LinkedListNode("b");
        LinkedListNode node6 = new LinkedListNode("a");
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
//        node4.next = node5;
        node5.next = node6;

        System.out.println(isPalindrome(node1));
    }

    public static Boolean isPalindrome(LinkedListNode list){

        int len = findLength(list);
//        LinkedListNode tempList = new LinkedListNode();
        if(len % 2 == 0){

        }
        LinkedListNode prev,curr;
        LinkedListNode reverse = new LinkedListNode();
        prev = new LinkedListNode();
        curr = list;
        prev.val = curr.val;
        prev.next = null;
        for(int i = 1; i < (len)/2; i++){
            LinkedListNode tmp = new LinkedListNode();
            curr = curr.next;
            tmp.val = curr.val;
            tmp.next = prev;
            prev = new LinkedListNode();
            prev.val = tmp.val;
            prev.next = tmp.next;
            reverse = tmp;
        }
        curr = len%2==0? curr.next : curr.next.next;
        while(curr != null && reverse != null){
            if(curr.val != reverse.val) return false;
            curr = curr.next;
            reverse = reverse.next;
        }
        return true;
    }

    private static int findLength(LinkedListNode list) {
        if(list == null) return  0;
        int len = 1;
        while(list.next != null){
            len++;
            list = list.next;
        }
        return len;

    }

}

