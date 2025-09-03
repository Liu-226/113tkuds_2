// 題目：Divide Two Integers
// 給定兩個整數 dividend（被除數）與 divisor（除數），請你實作整數除法，
// 限制不能使用乘法、除法以及取餘數運算。
// 請回傳截斷 (truncate) 小數後的商，並處理 32-bit 整數溢位情況。

class Solution {

    public int divide(int dividend, int divisor) {
        // 特殊情況：處理溢位
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // 超出範圍，回傳 2^31-1
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE; // 還在範圍內，直接回傳
        }

        // 判斷結果是否為負數
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // 轉換成 long 避免 overflow，並取絕對值
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // 位移法（類似長除法）
        // 目標：找出最大的 2^n * b <= a
        while (a >= b) {
            long temp = b;
            int multiple = 1;

            // 持續將除數擴大 2 倍，直到超過 a
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // 減去對應倍數的除數
            a -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }
}

/* 解題思路：
1. 題目限制不能用 * / %，因此必須用「位移 + 減法」模擬除法。
2. 特殊情況處理：
   - Integer.MIN_VALUE / -1 = 溢位，回傳 Integer.MAX_VALUE。
   - 其他邊界直接回傳。
3. 用 XOR 判斷結果正負號。
4. 將 dividend 與 divisor 轉成 long，並取絕對值，避免 overflow。
5. 主體演算法：
   - 透過左移 (<<) 模擬「倍增」除數，找到最大的倍數，使得 temp * 2^n <= dividend。
   - 減去該倍數，並將倍數加到結果。
   - 重複直到 dividend < divisor。
6. 最後依照符號回傳結果。
7. 時間複雜度 O(log n)，因為每次透過位移倍增。
   空間複雜度 O(1)。
 */
