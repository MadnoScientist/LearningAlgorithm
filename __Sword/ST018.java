public class ST018 {
    public static void main(String[] args) {

    }
}

class ST018_Solution {
    public static ListNode deleteNode1(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;
        head.next = deleteNode2(head.next, val);
        return head;
    }
}