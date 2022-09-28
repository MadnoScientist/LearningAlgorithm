/*
    剑指 Offer 06.丛尾到头打印链表
    描述：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    示例：
        输入：head = [1,3,2]
        输出：[2,3,1]
    https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
* */
import java.util.*;

public class ST06 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cnt = 0;
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (in.hasNextInt()) {
            tail.next = new ListNode(in.nextInt());
            tail = tail.next;
            cnt++;
        }
        int[] r1 = reverseLinkedList1(head.next);
        int[] r2 = reverseLinkedList2(head.next);
        boolean flag = true;
        for (int i = 0; i < cnt; i ++) {
            if (r1[i] != r2[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
        for (int num: r1) System.out.print(num+ " ");
    }

    public static int[] reverseLinkedList1(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    public static int[] reverseLinkedList2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        dfs(head, list);
        int n = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i ++) {
            res[i] = list.get(i);
        }
        return res;
    }
    private static void dfs(ListNode head, List<Integer> list) {
        if (head == null) return;
        dfs(head.next, list);
        list.add(head.val);
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
