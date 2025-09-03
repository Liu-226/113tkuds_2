// 題目：Valid Parentheses
// 給定一個字串 s，僅包含 '(', ')', '{', '}', '[' 和 ']'，判斷字串是否為有效括號
// 開括號必須由相同型別的閉括號關閉、以正確順序關閉、必須對應到一個開括號。

import java.util.*;

class Solution {

    public boolean isValid(String s) {
        // 使用堆疊來追蹤未匹配的開括號
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 如果是開括號，放進 stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 若遇到閉括號，先檢查 stack 是否為空
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                // 檢查是否對應正確
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        // 最後 stack 必須為空，才代表所有括號都匹配
        return stack.isEmpty();
    }
}

/*
解題思路：
1. 使用 Stack 追蹤括號配對：
   - 如果遇到開括號，就推入堆疊。
   - 如果遇到閉括號，就檢查堆疊頂端是否為對應的開括號。
2. 若堆疊為空時卻遇到閉括號，代表不合法。
3. 遍歷結束後，如果堆疊還有剩下未配對的開括號，也是不合法。
4. 時間複雜度 O(n)，每個字元只會進出堆疊一次；空間複雜度 O(n)。
*/
