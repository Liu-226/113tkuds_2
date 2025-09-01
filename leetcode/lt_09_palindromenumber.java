
class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        int[] tests = {121, -121, 10, 12321, 0};
        for (int num : tests) {
            System.out.println("Input: " + num + " => Output: " + isPalindrome(num));
        }
    }
}
