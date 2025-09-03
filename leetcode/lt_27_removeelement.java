// 題目：Remove Element
// 給定一個整數陣列 nums 和一個整數 val，請你「就地」移除所有數值等於 val 的元素，
// 並回傳移除後陣列的長度 k。
// 陣列中前 k 個元素必須是不等於 val 的數字，至於 k 之後的元素內容則不重要。

class Solution {

    public int removeElement(int[] nums, int val) {
        // 使用雙指針：index 表示目前可以放置不等於 val 元素的位置
        int index = 0;

        // 遍歷陣列
        for (int i = 0; i < nums.length; i++) {
            // 如果當前元素不等於 val，則保留
            if (nums[i] != val) {
                nums[index] = nums[i]; // 將該元素放到 index 位置
                index++;               // index 向後移動一位
            }
            // 如果等於 val，則跳過，不放進前面
        }

        // index 表示不等於 val 的元素數量
        return index;
    }
}

/* 解題思路：
1. 題目要求移除所有數值等於 val 的元素，並返回剩下元素的數量。
2. 使用「雙指針法」：
   - i：用來遍歷陣列。
   - index：用來記錄當前可放置的位置。
3. 當 nums[i] != val 時，將 nums[i] 覆蓋到 nums[index]，並讓 index++。
   當 nums[i] == val 時，跳過不處理。
4. 遍歷完成後，index 就是不等於 val 的元素數量，即答案 k。
5. 時間複雜度 O(n)，只需一次迴圈。
   空間複雜度 O(1)，不需額外陣列。
 */
