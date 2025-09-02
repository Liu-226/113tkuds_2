// 題目：Longest Common Prefix
// 給一個字串陣列，找出它們的最長共同前綴字串。
// 若不存在共同前綴，則回傳空字串。

class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // 以第一個字串作為基準
        String prefix = strs[0];

        // 逐一比較其餘字串
        for (int i = 1; i < strs.length; i++) {
            // 持續縮短直到符合目前字串的開頭
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}

/*
解題思路：
1. 最長共同前綴一定是某一個字串的前綴，因此可用第一個字串當基準。
2. 從第二個字串開始，逐一檢查是否以 prefix 開頭。
3. 若不是，則將 prefix 從後縮短一個字元，再檢查一次。
4. 重複直到符合條件或 prefix 變成空字串。
5. 時間複雜度 O(S)，其中 S 為所有字元的總數；空間複雜度 O(1)。
*/
