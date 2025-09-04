// 題目：Combination Sum II
// 給定一個整數陣列 candidates 和目標值 target，
// 找出所有唯一組合，使組合中數字和為 target，每個數字只能用一次，且不能有重複組合。

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // 先排序，方便去重
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path)); // 找到合法組合
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 跳過重複元素，避免生成重複組合
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 剪枝：因為已排序，若 candidates[i] > remaining，後面更大數字不可能符合
            if (candidates[i] > remaining) {
                break;
            }

            path.add(candidates[i]); // 做選擇
            backtrack(candidates, remaining - candidates[i], i + 1, path, result); // 下一層從 i+1 開始
            path.remove(path.size() - 1); // 撤銷選擇
        }
    }
}

/*
解題思路：
1. 排序 candidates，方便去重和剪枝。
2. 使用回溯法維護當前組合 path 和剩餘目標 remaining。
3. 遍歷 candidates：
   - 遇到重複元素跳過 (i > start && candidates[i] == candidates[i-1])。
   - 若 candidates[i] > remaining，剪枝退出。
   - 遞迴下一層從 i+1 開始，保證每個數字只能用一次。
4. 當 remaining == 0 時，將 path 加入結果。
5. 時間複雜度：取決於解空間，最壞為指數級。
   空間複雜度：O(target)，path 最長長度。
 */
