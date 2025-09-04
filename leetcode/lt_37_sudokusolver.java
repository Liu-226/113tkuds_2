// 題目：Sudoku Solver
// 解法：回溯法 (Backtracking)

class Solution {

    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 找到空格
                if (board[i][j] == '.') {
                    // 嘗試填入 1~9
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c; // 做選擇

                            if (backtrack(board)) {
                                return true; // 若成功，直接返回
                            }

                            board[i][j] = '.'; // 撤銷選擇
                        }
                    }
                    return false; // 9 個數字都不行，回溯
                }
            }
        }
        return true; // 全部填滿，結束
    }

    // 檢查當前填入是否符合數獨規則
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 檢查行
            if (board[row][i] == c) {
                return false;
            }
            // 檢查列
            if (board[i][col] == c) {
                return false;
            }
            // 檢查 3x3 小方格
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == c) {
                return false;
            }
        }
        return true;
    }
}

/*
解題思路：
1. 遍歷整個盤面，遇到 '.' 就嘗試填入 '1' ~ '9'。
2. 每次填入前先用 isValid() 檢查該數字是否符合規則：
   - 該列沒有重複
   - 該行沒有重複
   - 該 3x3 子區塊沒有重複
3. 若符合規則就遞迴處理下一個格子，若不行就回溯。
4. 當沒有 '.' 時，代表數獨完成。

時間複雜度：最壞情況接近 O(9^(81))，但實際上因為剪枝效果大幅減少。  
空間複雜度：O(1)，因為棋盤固定大小 9x9。
 */
