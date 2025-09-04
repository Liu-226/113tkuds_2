// 題目：Next Permutation
// 給定一個整數陣列 nums，找出它的下一個字典序排列。
// 必須在原地修改陣列，並且使用 O(1) 額外空間。

class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 1. 從右往左找到第一個遞增的數字 nums[i] < nums[i+1]
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // 2. 從右往左找到第一個比 nums[i] 大的數字，並交換
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. 反轉 i+1 到最後，讓後半部分變成最小的升序排列
        reverse(nums, i + 1, n - 1);
    }

    // 交換陣列中的兩個元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 反轉陣列區間 [start, end]
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}

/*
解題思路：
1. 從右往左找到第一個下降點 i，使得 nums[i] < nums[i+1]。
   - 如果不存在這樣的 i，說明整個陣列已經是最大排列，直接反轉為最小排列（升序）。
2. 再從右往左找到第一個比 nums[i] 大的數字 nums[j]，交換 nums[i] 與 nums[j]。
3. 最後將 i+1 到結尾的部分反轉，保證後半部分是最小的升序排列。
4. 時間複雜度 O(n)，空間複雜度 O(1)。
 */
