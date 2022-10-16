import java.util.Scanner;

public class ST021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int[] res = ST021_Solution.exchange(nums);
        for (int num: res) System.out.print(num + " ");
    }
}
class ST021_Solution {
    public static int[] exchange(int[] nums) {
        int n = nums.length;
        if (n == 0) return nums;
        int l = 0, r = n - 1;
        while (l < r) {
            while (l < r && nums[l ++] % 2 != 0);
            while (l < r && nums[r --] % 2 == 0);
            if (l < r) swap(nums, l, r);
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}