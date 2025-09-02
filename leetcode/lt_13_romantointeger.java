// 題目：Roman to Integer
// 給一個羅馬數字字串，轉換為整數並回傳。

class Solution {

    public int romanToInt(String s) {
        // 建立符號與數值的對應表
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        // 遍歷字串，每次和下一個比較
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            // 如果此次值小於下一個值，表示需要做減法
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                result -= value;
            } else {
                result += value;
            }
        }

        return result;
    }
}

/*
解題思路：
1. 羅馬數字通常由大到小排列，但遇到小數字在大數字之前時，需要做減法。
   - IV = 4, IX = 9
   - XL = 40, XC = 90
   - CD = 400, CM = 900
2. 我們將每個符號轉成對應數值。
3. 遍歷字串：
   - 若當前數值 < 下一個數值 → 減去當前值。
   - 否則 → 加上當前值。
4. 遍歷結束即可得到最終整數。
5. 時間複雜度 O(n)，空間複雜度 O(1)。
*/
