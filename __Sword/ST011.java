import java.util.Scanner;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 * 二分本质是两段性，即序列可以被分成满足条件的一段以及不满足条件的一段。
 * 本题中两段可以划分为大于等于旋转点的区间以及不满足的条件（不满足意味着最小点出现在这一段区间内）。旋转点为数组首个元素nums[0]。
 * 需要注意的是，由于数组中元素不唯一，可能存在形如 2，3，4，0，1，2，2的情况此时二段性丢失。
 * 需要去除数组末尾与旋转点相同的元素，从而保持二段性。
 */
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
        while(l < r && nums[l] == nums[r]) r--;
        while(l < r) {
            int mid = l + r >> 1;
            if(nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[r];
    }
}
//    int findMin(vector<int>& nums) {
//        int n = nums.size() - 1;
//        if (n < 0) return -1;
//        while (n > 0 && nums[n] == nums[0]) n -- ;
//        if (nums[n] >= nums[0]) return nums[0];
//        int l = 0, r = n;
//        while (l < r) {
//            int mid = l + r >> 1;       // [l, mid], [mid + 1, r]
//            if (nums[mid] < nums[0]) r = mid;
//            else l = mid + 1;
//        }
//        return nums[r];
//    }

