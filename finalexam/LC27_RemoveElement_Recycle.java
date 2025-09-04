
import java.util.*;

class Solution {

    public int removeElement(int[] nums, int val) {
        int write = 0;
        for (int x : nums) {
            if (x != val) {
                nums[write++] = x;
            }
        }
        return write;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int newLen = sol.removeElement(nums, val);

        System.out.println(newLen);
        for (int i = 0; i < newLen; i++) {
            System.out.print(nums[i]);
            if (i != newLen - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
