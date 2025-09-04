// 題目：Longest Valid Parentheses
// 給定一個只包含 '(' 和 ')' 的字串，回傳最長有效括號子字串的長度。

class Solution {

    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        // 初始化 -1 作為「最後一個未匹配位置」
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // 左括號，壓入索引
                stack.push(i);
            } else {
                // 右括號，彈出一個左括號匹配
                stack.pop();

                if (stack.isEmpty()) {
                    // 如果堆疊空了，把當前索引當作「最後未匹配位置」
                    stack.push(i);
                } else {
                    // 當前有效長度 = 當前索引 - 最後未匹配位置
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}

/*
解題思路（Stack 解法）：
1. 使用 stack 儲存「尚未匹配的括號索引」。
2. 初始時壓入 -1，代表「最後一個無效位置」。
3. 掃描字串：
   - 如果遇到 '('，壓入索引。
   - 如果遇到 ')'：
     a. 彈出一個元素。
     b. 如果 stack 空了，說明當前 ')' 沒有匹配，壓入它的索引作為新的無效位置。
     c. 否則，更新當前最長有效長度 = i - stack.peek()。
4. 回傳最大長度。
5. 時間複雜度 O(n)，空間複雜度 O(n)。

補充：也可以用 DP 或 雙向計數 (two-pass counting) 解法，空間可降為 O(1)。
 */
