// 題目：Remove Duplicates from Sorted Array
// 給定一個已排序的整數陣列 nums，請你「就地」移除重複的元素，
// 使每個元素只出現一次，並回傳移除後的新長度 k。
// 要求：保持原有相對順序，且只能用 O(1) 額外空間。

class Solution {

    public int removeDuplicates(int[] nums) {
        // 特殊情況：若陣列為空，直接回傳 0
        if (nums.length == 0) {
            return 0;
        }

        // 使用「雙指針」：
        // slow 指針：指向最後一個確認過的不重複元素
        // fast 指針：遍歷整個陣列
        int slow = 0;

        // 從第二個元素開始檢查（因為第一個元素必定保留）
        for (int fast = 1; fast < nums.length; fast++) {
            // 當 fast 指向的元素與 slow 指向的不同時，代表找到新元素
            if (nums[fast] != nums[slow]) {
                slow++;                 // 移動 slow，準備放置新元素
                nums[slow] = nums[fast]; // 覆蓋 slow 位置為新元素
            }
        }

        // slow 是最後一個不重複元素的位置，長度為 slow + 1
        return slow + 1;
    }
}

/* 解題思路：
1. 陣列已經排序，重複元素必定是連續的。
2. 使用雙指針法：
   - slow：記錄最後一個唯一元素的位置。
   - fast：用來遍歷陣列尋找下一個不同的元素。
3. 當 nums[fast] != nums[slow] 時，代表找到新唯一值，
   將其放到 slow+1 的位置，並移動 slow。
4. 最後返回 slow+1，即唯一元素的數量 k。
5. 時間複雜度 O(n)，因為只需一次遍歷。
   空間複雜度 O(1)，因為不使用額外陣列。
 */
