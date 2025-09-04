
import java.util.*;

class Solution {

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length(), m = needle.length();
        if (m > n) {
            return -1;
        }

        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            for (; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();

        Solution sol = new Solution();
        int idx = sol.strStr(haystack, needle);
        System.out.println(idx);
    }
}
