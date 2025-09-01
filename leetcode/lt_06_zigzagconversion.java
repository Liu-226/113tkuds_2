
class Solution {

    public static String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // 到頂或到底時反轉方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // 合併所有行
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("Example 1 Output: " + convert(s1, numRows1)); // PAHNAPLSIIGYIR

        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("Example 2 Output: " + convert(s2, numRows2)); // PINALSIGYAHRPI

        String s3 = "A";
        int numRows3 = 1;
        System.out.println("Example 3 Output: " + convert(s3, numRows3)); // A
    }
}
