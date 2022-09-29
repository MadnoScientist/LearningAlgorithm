import java.util.Scanner;

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
