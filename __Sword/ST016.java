import java.util.Scanner;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * 数据范围
 *         -100.0 < x < 100.0
 *         -2^31 <= n <= 2^31-1
 *         -104 <= x^n <= 104
 * 题解：
 *  快速幂模板
 *      public static long qmi(long a, long k, long p) {
 *         long res = 1;
 *         while (k != 0) {
 *             if ((k & 1) == 1) res = res * a % p;
 *             a = a * a % p;
 *             k = k >> 1;
 *         }
 *         return res;
 *     }
 *  由于本题说明不需要考虑大数问题不需要循环取余。
 *  细节是输入范围n可以取到-2^31，此情况下运下 n = -n，由于2^31超出int32范围会报错。需要用long存储n。
 *
 */
public class ST016 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        int n = in.nextInt();
        System.out.println(ST016_Solution.myPow(x, n));
    }
}
class ST016_Solution {
    public static double myPow(double x, int n) {
        double res = 1.0;
        long b = n;
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        //快速幂模板
        while (b != 0) {
            if ((b & 1) == 1) res = res * x;
            x = x * x;
            b = b >> 1;
        }
        return res;
    }
}
