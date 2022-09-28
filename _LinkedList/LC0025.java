import java.util.Scanner;

/**
 * LeetCode 25 - K个一组翻转链表
 * 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 样例1：
 * In: 1, 2, 3, 4, 5    k = 2
 * Out: 2, 1, 4, 3, 5
 * 样例2：
 * In: 1, 2, 3, 4, 5    k = 3
 * Out: 3, 2, 1, 4, 5
 */
public class LC0025 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (in.hasNextInt()) {
            tail.next = new ListNode(in.nextInt());
            tail = tail.next;
        }
        ListNode temp = Solution_LC0025.reverseKGroup(head.next, k);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}

class Solution_LC0025 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间[a, b)包含k个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足k个，不需要反转
            if (b == null) return head;
            b = b.next;
        }
        // 反转[a, b)区间k个元素
        ListNode prev = null;
        ListNode curr = a;
        ListNode next = null;
        while (curr != b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 退出循环时curr指向b，prev指向b的前驱即反转后新的头节点
        ListNode newHead = prev;
        // 反转后a节点为尾节点，a节点指向下一个长度为k的待反转区间
        // 即以b节点为首，下一个长度为k的区间
        a.next = reverseKGroup(b, k);
        return newHead;
    }
}


class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
