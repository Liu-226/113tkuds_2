// 題目：Substring with Concatenation of All Words
// 給定一個字串 s 和一個字串陣列 words，所有 words[i] 長度相同。
// 找出所有起始索引，使得 s 中的子字串恰好是 words 的任意排列組合拼接而成。

class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        // 使用 HashMap 統計 words 中每個單字出現次數
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // 因為單字長度固定，我們可以從 wordLen 個不同的 offset 開始檢查
        for (int i = 0; i < wordLen; i++) {
            int left = i; // 視窗左邊界
            int count = 0; // 計算已匹配的單字數
            Map<String, Integer> windowMap = new HashMap<>();

            for (int right = i; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果某個單字出現次數超過，縮小左邊界
                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // 如果剛好匹配所有單字，加入答案
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // 單字不在 wordMap，清空視窗
                    windowMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}

/*
解題思路：
1. 題目要求找到所有由 words 中單字排列組合而成的子字串起始索引。
2. 因為所有 words[i] 長度相同 (wordLen)，我們可以用「固定長度滑動視窗」方式處理。
3. 步驟：
   - 建立 wordMap 統計 words 的出現次數。
   - 對 s 進行 wordLen 種偏移檢查，避免漏掉可能起始點。
   - 使用 windowMap 記錄當前視窗的單字計數，當某個單字超出 wordMap 的需求時，縮小視窗。
   - 當 windowMap 剛好符合 wordMap 時，記錄答案。
4. 時間複雜度 O(n * wordLen)，其中 n = s.length()。
5. 空間複雜度 O(m)，m = words.length（HashMap 儲存單字）。
 */
