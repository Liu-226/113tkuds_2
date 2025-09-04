// 題目：Combination Sum
// 找出所有數字組合，使其和等於 target，數字可重複使用

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            // 找到有效組合
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remaining) {
                path.add(candidates[i]); // 做選擇
                backtrack(candidates, remaining - candidates[i], i, path, result); // 遞迴，可重複使用
                path.remove(path.size() - 1); // 撤銷選擇
            }
        }
    }
}

/*
解題思路：
1. 使用回溯法維護當前組合 path 和剩餘目標 remaining。
2. 遍歷 candidates 從 start 索引開始，避免生成重複組合。
3. 當 remaining == 0 時，將當前 path 加入結果。
4. 遞迴時：
   - 同一元素可重複使用，所以下一層遞迴 start = i。
   - 用過的元素撤銷選擇後繼續嘗試下一個元素。
5. 時間複雜度：取決於解空間，最壞情況指數級。
   空間複雜度：O(target)，path 的最大長度。
 */
