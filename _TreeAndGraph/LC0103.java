import java.util.*;

/**
 * LeetCode 103 - 二叉树的锯齿形（ZigZag)层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 *
 */

public class LC0103 {
    static int N = 2010;
    static int[] a = new int[N];
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
        int cnt = 0;
        while (in.hasNext()) {
            String input = in.next();
            a[cnt ++] = input.equals("null") ? (int)-1e9 : Integer.parseInt(input);
        }

        TreeNode root = buildTree(a, 0, cnt);

        List<List<Integer>> res = LC0103_Solution.zigzagLevelOrder(root);
        for (List<Integer> list: res) {
            for (int x: list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

class LC0103_Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = true;
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode.left!=null){
                    queue.add(curNode.left);
                }
                if(curNode.right!=null){
                    queue.add(curNode.right);
                }
                if(flag){
                    list.add(0,curNode.val);
                }else{
                    list.add(curNode.val);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }
}

