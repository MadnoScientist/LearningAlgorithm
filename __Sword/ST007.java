import java.util.*;

/**
 * ST 07 - 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <a href="https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/?favorite=xb9nqhhg">...</a>
 * 同类型题目 LeetCode 0106 - 从中序与后序遍历序列构造二叉树
 */

public class ST007 {
    static int N = 5010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i ++) a[i] = in.nextInt();
        for (int i = 0; i < n; i ++) b[i] = in.nextInt();

        TreeNode root = ST007_Solution.buildTree(a, b, n);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode curNode = queue.poll();
                level.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            System.out.println(level);
        }
    }
}

class ST007_Solution {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inoStart, int inoEnd) {
        if (preStart > preEnd || inoStart > inoEnd) {
            return null;
        }

        int preorder_root = preStart;
        TreeNode root = new TreeNode(preorder[preorder_root]);

        int index = map.get(preorder[preorder_root]);
        int size_left_subtree = index - inoStart;

        root.left = build(preorder, inorder, preStart + 1, preEnd + size_left_subtree, inoStart, index - 1);
        root.right = build(preorder, inorder, preStart + size_left_subtree + 1, preEnd, index + 1, inoEnd);
        return root;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder, int n) {
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}