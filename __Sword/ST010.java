import java.util.Scanner;

public class ST010 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = ST010_Solution.numWays(n);
        System.out.println(res);
    }
}
class ST010_Solution {
    public static int numWays(int n) {
        if (n == 0 || n == 1) return 1;
        int a = 1, b = 1;
        int sum = 0;
        int mod = (int)1e9 + 7;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % mod;
            a = b;
            b = sum;
        }
        return sum;
    }
}