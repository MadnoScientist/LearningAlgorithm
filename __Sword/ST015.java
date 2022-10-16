import java.util.Scanner;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 *
 * 题解：
 *  n & 1 -> n的二进制表示末位
 *  n >>> 1 无符号右移（无论n为正数还是负数，都在高位补0）
 *  n & (n - 1) -> 使得n最末位的1变为0
 *  本题中n为无符号整形
 */
public class ST015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine(),2);
        int res = ST015_Solution.hammingWeight1(n);
        System.out.println(res);
    }
}

class ST015_Solution {
    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res ++;
            n &= (n - 1);
        }
        return res;
    }
}