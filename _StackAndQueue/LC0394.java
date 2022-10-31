import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LC0394 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String res = LC0394_Solution.decodeString(s);
        System.out.println(res);
    }
}

class LC0394_Solution {
    public static String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (s.charAt(i) == ']') {
                stack.pop();
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                StringBuilder ks = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    ks.append(stack.pop());
                }
                int k = Integer.parseInt(ks.reverse().toString());
                String ss = "";
                sb.reverse();
                for (int j = 0; j < k; j++) {
                    ss += sb.toString();
                }
                char[] cs = ss.toCharArray();
                for (char c: cs) stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.pollLast());
        return res.toString();
    }
}