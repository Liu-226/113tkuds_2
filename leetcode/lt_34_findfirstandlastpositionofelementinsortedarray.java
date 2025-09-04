// 題目：Find First and Last Position of Element in Sorted Array
// 給定一個升序（可有重複值）的整數陣列 nums 和整數 target，
// 找到 target 的起始與結束索引，若不存在則回傳 [-1, -1]。
// 時間複雜度必須為 O(log n)。

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);   // 找左邊界
        int last = findBound(nums, target, false);   // 找右邊界
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int bound = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                bound = mid;
                // 如果找左邊界，往左移
                if (isFirst) {
                    right = mid - 1;
                } else {
                    // 找右邊界，往右移
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return bound;
    }
}

/*
解題思路：
1. 使用兩次二分搜尋：
   - 第一次找 target 的最左邊界 (first position)。
   - 第二次找 target 的最右邊界 (last position)。
2. 在二分搜尋過程中，如果找到 target：
   - 如果要找左邊界，繼續往左移動 (right = mid - 1)。
   - 如果要找右邊界，繼續往右移動 (left = mid + 1)。
3. 如果 target 不存在，兩次搜尋都會回傳 -1。
4. 時間複雜度 O(log n)，空間複雜度 O(1)。
 */
