import java.util.*;

/**
 * LeetCode 617 - 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。注意: 合并过程必须从两个树的根节点开始。
 *
 */

public class LC0617 {
    static int N = 2010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    private static TreeNode buildTree(int[] arr, int idx, int length) {
        TreeNode root = null;
        if (idx < length) {
            if (arr[idx] == (int)-1e9) {
                return null;
            } else {
                root = new TreeNode(arr[idx]);
                root.left = buildTree(arr, 2 * idx + 1, length);
                root.right = buildTree(arr, 2 * idx + 2, length);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] ss1 = in.nextLine().split(" ");
        int cnt1 = 0;
        for (String s: ss1) {
            a[cnt1 ++] = s.equals("null") ? (int)-1e9 : Integer.parseInt(s);
        }
        String[] ss2 = in.nextLine().split(" ");
        int cnt2 = 0;
        for (String s: ss2) {
            b[cnt2 ++] = s.equals("null") ? (int)-1e9 : Integer.parseInt(s);
        }

        TreeNode root1 = buildTree(a, 0, cnt1);
        TreeNode root2 = buildTree(b, 0, cnt2);

        TreeNode root = LC0617_Solution.mergeTrees(root1, root2);

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

class LC0617_Solution {
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}