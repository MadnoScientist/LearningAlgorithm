import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ST017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] res = ST017_Solution.printNumbers1(n);
        for (int num: res) System.out.print(num + " ");
        ST017_Solution.printNumbers2(n);
    }
}
class ST017_Solution {
    
    // 整数范围内
    public static int[] printNumbers1(int n) {
        int max_bound = 1;
        while (n != 0) {
            max_bound *= 10;
            n --;
        }
        max_bound --;
        int[] res = new int[max_bound];
        for (int i = 1; i <= max_bound; i ++) {
            res[i - 1] = i;
        }
        return res;
    }
    private static List<String> list = new ArrayList<>();
    private static StringBuffer track = new StringBuffer();
    // 注意：这里改为返回 String[] 类型，配合大数的情况
    public static String[] printNumbers2(int n) {
        dfs(n, 0);
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    private static void dfs(int n, int cur) {
        // 说明得到了一个可行的字符串数字
        if (cur == n) {
            // 如果 track 长度为 0，则不加入
            // 为了避免全 0 的情况
            if (track.length() != 0) list.add(track.toString());
            return ;
        }
        for (int i = 0; i <= 9; i++) {
            // 如果 track 长度为 0 且 i = 0，则不加入
            // 以长度 3 为例，为了避免 000，001，010 等情况
            boolean isNotAdd = track.length() == 0 && i == 0;
            if (!isNotAdd) track.append(i);
            dfs(n, cur + 1);
            // 回溯时，也需要判断前面是否加入
            if (!isNotAdd) track.deleteCharAt(track.length() - 1);
        }
    }
}
