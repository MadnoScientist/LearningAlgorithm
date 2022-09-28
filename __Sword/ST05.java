

import java.util.Scanner;

public class ST05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String res1 = ST05_Solution.replaceSpace1(s);
        String res2 = ST05_Solution.replaceSpace2(s);
        String res3 = ST05_Solution.replaceSpace3(s);
        assert (res1.equals(res2) && res2.equals(res3));

    }


}

class ST05_Solution {
    public static String replaceSpace1(String s) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                sb.append(s, j, i);
                sb.append("%20");
                j = i + 1;
            }
        }
        sb.append(s, j, s.length());
        return sb.toString();
    }

    public static String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String replaceSpace3(String s) {
        return s.replace(" ", "%20");
    }
}

