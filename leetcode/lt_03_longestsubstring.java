
class Solution {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;  // 滑動窗口左邊界
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 如果字符已經在窗口中，移動左邊界直到沒有重複
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Input: " + s1 + " => Output: " + lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Input: " + s2 + " => Output: " + lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Input: " + s3 + " => Output: " + lengthOfLongestSubstring(s3));

        String s4 = "";
        System.out.println("Input: " + s4 + " => Output: " + lengthOfLongestSubstring(s4));
    }
}
