import java.util.Scanner;

/**
 * ST 07 - 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/?favorite=xb9nqhhg
 */

public class ST007 {
    static int N = 5010;
    static int[] a = new int[N];
    static int[] b = new int[N];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i ++) a[i] = in.nextInt();
        for (int i = 1; i <= n; i ++) b[i] = in.nextInt();

    }
}
