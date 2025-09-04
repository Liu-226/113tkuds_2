// 題目：Search Insert Position
// 給定一個升序且無重複元素的整數陣列 nums 和整數 target。
// 如果 target 存在，回傳其索引；如果不存在，回傳它應插入的位置。
// 必須在 O(log n) 時間內完成。

class Solution {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // 找到 target，直接回傳
            } else if (nums[mid] < target) {
                left = mid + 1; // target 在右半邊
            } else {
                right = mid - 1; // target 在左半邊
            }
        }

        // 沒找到，left 會是插入位置
        return left;
    }
}

/*
解題思路：
1. 用二分搜尋判斷 target 是否存在於 nums 中。
2. 如果找到，直接回傳索引。
3. 如果沒找到，最後 while 迴圈結束時：
   - left 剛好是 target 應該插入的位置。
4. 時間複雜度 O(log n)，空間複雜度 O(1)。
 */
