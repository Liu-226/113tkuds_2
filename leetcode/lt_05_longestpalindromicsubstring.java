
class Solution {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);      // 回文長度為奇數
            int len2 = expandAroundCenter(s, i, i + 1);  // 回文長度為偶數
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 回文長度
    }

    public static void main(String[] args) {
        String s1 = "babad";
        System.out.println("Input: " + s1 + " => Output: " + longestPalindrome(s1));

        String s2 = "cbbd";
        System.out.println("Input: " + s2 + " => Output: " + longestPalindrome(s2));

        String s3 = "a";
        System.out.println("Input: " + s3 + " => Output: " + longestPalindrome(s3));
    }
}
