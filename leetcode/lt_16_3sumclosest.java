// 題目：3Sum Closest
// 給定一個整數陣列 nums 與一個目標值，
// 找出三個整數，使得它們的和最接近目標值，並回傳這個和。
// 假設輸入保證有唯一解。

class Solution {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // 初始值

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // 若此組合更接近目標，更新答案
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum == target) {
                    return sum; // 已經完全相等，直接回傳
                } else if (sum < target) {
                    left++; // 需要更大數字
                } else {
                    right--; // 需要更小數字
                }
            }
        }

        return closestSum;
    }
}

/*
解題思路：
1. 先將陣列排序方便搜尋。
2. 外層迴圈固定一個數 nums[i]，內層使用雙指針 (left, right) 搜索另外兩個數。
3. 每次計算三數之和，若更接近目標，則更新 closestSum。
4. 根據 sum 與 target 的比較：
   - sum == target → 直接回傳 target。
   - sum < target → left++（需要更大）。
   - sum > target → right--（需要更小）。
5. 迴圈結束後，回傳 closestSum。
6. 時間複雜度 O(n^2)，排序 O(n log n)，雙指針搜尋 O(n^2)；空間複雜度 O(1)。
*/
