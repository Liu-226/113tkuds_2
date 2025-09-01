
class Solution {

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char pre = p.charAt(j - 2);

                    dp[i][j] = dp[i][j - 2];

                    if (pre == sc || pre == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String[][] tests = {
            {"aa", "a"},
            {"aa", "a*"},
            {"ab", ".*"},
            {"mississippi", "mis*is*p*."},
            {"ab", ".*c"}
        };

        for (String[] test : tests) {
            System.out.println("s = \"" + test[0] + "\", p = \"" + test[1] + "\" => " + isMatch(test[0], test[1]));
        }
    }
}
