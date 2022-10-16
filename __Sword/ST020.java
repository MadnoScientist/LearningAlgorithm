public class ST020 {
    public static void main(String[] args) {

    }
}

class ST020_Solution {
    public static boolean isNumber(String s) {
        int n = s.length();
        s = s.trim();
        boolean numFlag = false, dotFlag = false, eFlag = false;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numFlag = true;
            } else if (c == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            } else if ((c == 'e' || c == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;
            } else if ((c == '+' ||c == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                continue;
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
