
class Solution {

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int x1 = 123;
        System.out.println("Input: " + x1 + " => Output: " + reverse(x1));

        int x2 = -123;
        System.out.println("Input: " + x2 + " => Output: " + reverse(x2));

        int x3 = 120;
        System.out.println("Input: " + x3 + " => Output: " + reverse(x3));

        int x4 = 1534236469;
        System.out.println("Input: " + x4 + " => Output: " + reverse(x4));
    }
}
