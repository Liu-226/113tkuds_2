// 題目：Generate Parentheses
// 給定 n 對括號，生成所有有效且配對正確的括號組合。

import java.util.*;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // 從空字串開始回溯
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * 回溯函式
     *
     * @param result 儲存結果的 List
     * @param current 當前生成的字串
     * @param open 已使用的左括號數量
     * @param close 已使用的右括號數量
     * @param max 總共 n 對括號
     */
    private void backtrack(List<String> result, String current, int open, int close, int max) {
        // 如果當前字串長度達到 2*max，表示完成一組合法括號
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // 如果左括號數量小於 n，還可以加 '('
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // 如果右括號數量小於左括號數量，還可以加 ')'
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}

/*
解題思路：
1. 使用回溯法（Backtracking）生成所有可能的括號組合。
2. 每一步可以選擇加 '(' 或 ')'：
   - 只有當左括號數量 < n 時，才能加 '('。
   - 只有當右括號數量 < 左括號數量時，才能加 ')'，確保配對正確。
3. 當當前字串長度 == 2*n，表示生成了一組合法括號，加入結果。
4. 遞歸探索所有可能的合法組合。
5. 時間複雜度 O(4^n / sqrt(n))，空間複雜度 O(n)（遞歸深度）。
 */
