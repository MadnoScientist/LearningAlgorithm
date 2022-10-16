import java.util.Scanner;

public class ST014 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = ST014_Solution.cuttingRope(n);
        System.out.println(n);
    }
}
class ST014_Solution {
    public static int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int mod = (int)1e9 + 7;
        long res = 1;
        while (n > 4) {
            res = res * 3 % mod;
            n -= 3;
        }
        return (int)(res * n % mod);
    }
}