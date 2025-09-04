
import java.util.*;

class Solution {

    private static final String[] KEYS = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", // 5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz" // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        backtrack(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder path, String digits, int idx) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        String letters = KEYS[digits.charAt(idx) - '0'];
        for (char c : letters.toCharArray()) {
            path.append(c);
            backtrack(res, path, digits, idx + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine().trim();

        Solution sol = new Solution();
        List<String> ans = sol.letterCombinations(digits);

        for (String s : ans) {
            System.out.println(s);
        }
    }
}
