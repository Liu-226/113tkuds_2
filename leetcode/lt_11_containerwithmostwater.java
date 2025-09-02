// 題目：Container With Most Water
// 給定一個整數陣列 height，其中 height[i] 表示第 i 條垂直線的高度。
// 找出兩條線，讓它們跟 x 軸構成的容器可以儲存最多的水，並回傳最大容量。

class Solution {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // 從左右兩端往中間移動
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxArea = Math.max(maxArea, area);

            // 移動較矮的那一端，因為高度才是極限
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

/*
解題思路：
1. 題目要求找到能形成最大儲水量的兩條線。
2. 從最左和最右開始，計算目前容量。
3. 每次移動高度較小的那一端，因為容量受限於最矮的線。
4. 重複直到左右指針相遇，過程中更新最大容量。
5. 時間複雜度 O(n)，空間複雜度 O(1)。
*/
