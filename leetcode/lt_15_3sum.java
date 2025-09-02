// 題目：3Sum
// 給定一個整數陣列nums，找出所有不重複的三元組 [nums[i], nums[j], nums[k]]，
// 使nums[i] + nums[j] + nums[k] == 0。
// 不能包含重複的組合。

import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 先排序，方便處理與避免重複

        for (int i = 0; i < nums.length - 2; i++) {
            // 若當前數字與前一個相同，跳過避免重複
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 跳過重複的 left 與 right
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // 需要更大的數字
                } else {
                    right--; // 需要更小的數字
                }
            }
        }

        return result;
    }
}

/*
解題思路：
1. 題目要求找出所有和為0的三元組，且不能重複。
2. 先將陣列排序
3. 外層迴圈固定一個數 nums[i]，內層使用雙指針 (left, right) 搜索另外兩個數。
4. 根據 sum 判斷：
   - sum == 0 → 加入結果，並跳過重複數字。
   - sum < 0 →（需要更大數字）。
   - sum > 0 →（需要更小數字）。
5. 過程中要注意，不能讓結果出現重複三元組。
6. 時間複雜度 O(n^2)，排序 O(n log n)，雙指針搜尋 O(n^2)；空間複雜度 O(1)。
*/
