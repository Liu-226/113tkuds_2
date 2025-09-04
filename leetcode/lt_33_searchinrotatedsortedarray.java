// 題目：Search in Rotated Sorted Array
// 已知一個升序陣列（無重複值），可能在某個未知位置被旋轉。
// 給定旋轉後的陣列 nums 和整數 target，請找出 target 的索引，若不存在回傳 -1。
// 時間複雜度必須為 O(log n)。

class Solution {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判斷哪一半是有序的
            if (nums[left] <= nums[mid]) {
                // 左半邊有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target 在左半邊
                } else {
                    left = mid + 1;  // target 在右半邊
                }
            } else {
                // 右半邊有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // target 在右半邊
                } else {
                    right = mid - 1; // target 在左半邊
                }
            }
        }
        return -1; // 沒找到
    }
}

/*
解題思路：
1. 使用二分搜尋，但因為陣列可能被旋轉，需要先判斷「哪一半是有序的」。
2. 觀察 nums[mid] 與 nums[left]、nums[right]：
   - 如果 nums[left] <= nums[mid]，代表左半部分有序。
   - 否則右半部分有序。
3. 一旦確定哪一半有序，就可以判斷 target 是否落在該範圍：
   - 如果是，就在該半邊繼續二分搜尋。
   - 否則到另一半繼續搜尋。
4. 時間複雜度 O(log n)，空間複雜度 O(1)。
 */
