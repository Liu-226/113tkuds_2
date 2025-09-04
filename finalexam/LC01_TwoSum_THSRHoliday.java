
import java.util.*;

class Solution {

    public int[] assignSeats(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (map.containsKey(cur)) {
                return new int[]{map.get(cur), i};
            }

            map.put(target - cur, i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        int[] ans = sol.assignSeats(nums, target);

        System.out.println(ans[0] + " " + ans[1]);
    }
}
