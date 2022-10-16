public class ST024 {
}

class ST024_Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newNode;
    }

    public ListNode reverseList_iteration(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
