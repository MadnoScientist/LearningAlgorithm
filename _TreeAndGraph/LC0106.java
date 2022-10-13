import java.util.*;

/**
 * LeetCode 0106 - 从中序与后序遍历序列构造二叉树
 *
 */

public class LC0106 {
    static int N = 5010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i ++) a[i] = in.nextInt();
        for (int i = 0; i < n; i ++) b[i] = in.nextInt();

        TreeNode root = LC0106_Solution.buildTree(a, b, n);

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

class LC0106_Solution {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode build(int[] inorder, int[] postorder, int inoStart, int inoEnd, int postStart, int postEnd) {
        if (inoStart > inoEnd || postEnd > postStart) {
            return null;
        }

        int postorder_root = postEnd;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(postorder[postorder_root]);



        root.left = build(inorder, postorder, inoStart, index, postStart, postStart + index - inoStart);
        root.right = build(inorder, postorder, index + 1, inoEnd, postStart + index - inoStart, postEnd - 1);
        return root;
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder, int n) {
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, n - 1, 0, n - 1);
    }
}