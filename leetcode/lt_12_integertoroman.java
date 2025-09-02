// 題目：Integer to Roman
// 給定一個整數 num (1 <= num <= 3999)，並轉換為羅馬數字回傳。

class Solution {

    public String intToRoman(int num) {
        // 定義所有可能的符號與數值
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder result = new StringBuilder();

        // 遍歷所有數值，扣除num
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }

        return result.toString();
    }
}

/*
解題思路：
1. 羅馬數字由固定的符號組成，並遵循加法與減法規則。
2. 將所有可能的數值與對應符號列出，包含特殊的情況。 
3. 從最大值開始，不斷減掉對應的數字並拼接符號。
4. 重複直到 num 為 0。
5. 時間複雜度 O(1)，因為最大輸入 3999，轉換步驟有限；空間複雜度 O(1)。
*/
