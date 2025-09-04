// 題目：Count and Say
// 返回第 n 個 count-and-say 序列

class Solution {

    public String countAndSay(int n) {
        String result = "1"; // base case

        for (int i = 2; i <= n; i++) {
            result = nextSequence(result);
        }

        return result;
    }

    // 根據上一個序列生成下一個序列
    private String nextSequence(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            // 如果下一個字符相同，計數
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                // 否則將 count + character 加入結果
                sb.append(count);
                sb.append(s.charAt(i));
                count = 1; // 重置計數
            }
        }
        return sb.toString();
    }
}

/*
解題思路：
1. 從 n = 1 開始，序列為 "1"。
2. 對每個 n > 1，根據上一個序列做 RLE 生成下一個序列：
   - 遍歷上一個序列，計算連續相同字符的數量。
   - 將 count + character 拼接成新序列。
3. 迭代直到 n，返回結果。

時間複雜度：每次生成下一個序列需要 O(m)，m 為上一序列長度。序列長度成長約為指數級，但 n <= 30 可接受。
空間複雜度：O(m)，存儲當前序列。
 */
