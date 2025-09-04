// 題目：Valid Sudoku
// 檢查一個 9x9 的數獨盤面是否合法。
// 只需驗證已填寫的數字，'.' 代表空格可忽略。

import java.util.*;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        // 使用三個集合陣列，分別檢查 row, col, box
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // 開始掃描盤面
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue; // 跳過空格
                }
                // 計算此格子屬於哪個 3x3 box
                int boxIndex = (i / 3) * 3 + (j / 3);

                // 檢查是否違反規則
                if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)) {
                    return false;
                }

                // 加入集合
                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIndex].add(c);
            }
        }

        return true; // 沒有違規，合法
    }
}

/*
解題思路：
1. 用三個 Set[] 來追蹤：
   - rows[i]: 第 i 列出現過的數字
   - cols[j]: 第 j 行出現過的數字
   - boxes[k]: 第 k 個 3x3 子方格出現過的數字
     （k = (i / 3) * 3 + (j / 3)）
2. 掃描整個盤面，遇到數字就檢查是否已經存在於該 row/col/box。
   - 若存在，回傳 false。
   - 否則加入集合。
3. 掃描結束，沒有重複就回傳 true。
時間複雜度：O(81) = O(1)，因為固定 9x9 盤面。
空間複雜度：O(81) = O(1)，最多儲存 81 個數字。
 */
