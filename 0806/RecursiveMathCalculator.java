
public class RecursionFunctions {

    public static long binomial(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return binomial(n - 1, k - 1) + binomial(n - 1, k);
    }

    public static long catalan(int n) {
        if (n <= 1) {
            return 1;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - 1 - i);
        }
        return res;
    }

    public static long hanoiMoves(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 2 * hanoiMoves(n - 1) + 1;
    }

    public static boolean isPalindrome(long x) {
        if (x < 0) {
            return false;
        }
        return isPalHelper(x, reverseDigits(x, 0));
    }

    private static long reverseDigits(long x, long rev) {
        if (x == 0) {
            return rev;
        }
        return reverseDigits(x / 10, rev * 10 + (x % 10));
    }

    private static boolean isPalHelper(long x, long rev) {
        return x == rev;
    }
}
