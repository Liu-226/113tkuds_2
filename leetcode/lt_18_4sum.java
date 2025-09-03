// 題目：4Sum
// 給定一個整數陣列 nums 和一個目標值 target，回傳所有不重複的四元組 [nums[a], nums[b], nums[c], nums[d]]，
// 使得 nums[a] + nums[b] + nums[c] + nums[d] == target。

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 先排序，方便去除重複解與使用雙指標

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            // 避免第一層重複解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // 避免第二層重複解
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    // 用 long 避免整數溢位

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 移動指標避免重複解
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // 總和太小，移動左指標
                    } else {
                        right--; // 總和太大，移動右指標
                    }
                }
            }
        }

        return result;
    }
}

/*
解題思路：
1. 這題是 Two Sum / Three Sum 的延伸版，要找出四個數字相加等於 target。
2. 先將陣列排序，方便處理重複值並用雙指標法。
3. 使用兩層迴圈固定前兩個數字 nums[i], nums[j]，然後在剩下區間用雙指標 (left, right) 找出符合的組合。
4. 若總和 == target，就加入結果，並移動 left 和 right 避免重複解。
5. 若總和 < target，則 left++；若總和 > target，則 right--。
6. 時間複雜度：O(n^3)，因為三層迴圈 + 雙指標搜尋；n 最大為 200，仍可接受。
*/
