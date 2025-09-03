// 題目：Find the Index of the First Occurrence in a String
// 給定兩個字串 haystack 和 needle，回傳 needle 在 haystack 中第一次出現的索引位置。
// 若 needle 不存在於 haystack 中，則回傳 -1。

class Solution {

    public int strStr(String haystack, String needle) {
        // 特殊情況：如果 needle 為空字串，通常定義為回傳 0
        if (needle.length() == 0) {
            return 0;
        }

        // 遍歷 haystack，只需檢查到 haystack.length - needle.length 位置即可
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // 截取長度等於 needle 的子字串，與 needle 比較
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // 找到第一次出現的位置
            }
        }

        // 若沒找到，回傳 -1
        return -1;
    }
}

/* 解題思路：
1. 題目要求找到字串 needle 在 haystack 中第一次出現的位置。
2. 逐一檢查 haystack 中所有可能的起始位置：
   - 只需檢查到 haystack.length - needle.length 為止，避免越界。
   - 使用 substring(i, i + needle.length) 取出子字串，與 needle 比較。
3. 若找到相等的子字串，立刻回傳其起始索引 i。
4. 若整個 haystack 檢查完都沒有匹配，則回傳 -1。
5. 時間複雜度 O((n-m+1)*m)，其中 n = haystack 長度，m = needle 長度。
   空間複雜度 O(1)。
 */
