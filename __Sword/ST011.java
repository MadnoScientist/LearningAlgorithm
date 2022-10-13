import java.util.Scanner;

public class ST011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i ++) a[i] = in.nextInt();
        int res = ST011_Solution.minArray(a);
        System.out.println(res);
    }
}

class ST011_Solution {
    public static int minArray(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r && nums[0] == nums[r]) r--;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        return r + 1 < n ? nums[r + 1] : nums[0];
    }
}