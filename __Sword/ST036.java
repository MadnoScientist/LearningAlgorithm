/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 题解：
 *  由于是二叉搜索树，中序遍历可以构成升序序列，即题意要求的排序顺序，
 */

public class ST036 {
    public static void main(String[] args) {

    }
}

class ST036_Solution {
    TreeNode prev, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        dfs(root);
        head.left = prev;
        prev.right = head;
        return head;
    }
    private void dfs(TreeNode curr) {
        if (curr == null) return;
        dfs(curr.left);
        // prev -> <- curr
        // 然后移动prev指针到当前位置
        // 特殊情况是叶子节点
        if (prev != null) prev.right = curr;
        else head = curr;
        curr.left = prev;
        prev = curr;
        dfs(curr.right);
    }
}