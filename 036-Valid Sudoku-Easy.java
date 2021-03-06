import java.util.HashSet;

/**
 * Created by ywwynm on 2017/1/4.
 *
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set1 = new HashSet<>(9);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!set1.add(board[i][j])) {
                    System.out.println("row: " + i + ", " + j);
                    return false;
                }
            }
            set1.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') continue;
                if (!set1.add(board[j][i])) {
                    System.out.println("col: " + i + ", " + j);
                    return false;
                }
            }
            set1.clear();
        }

        // i < 3, j < 3; 3 <= i < 6, j < 3; 6 <= i < 9, j < 3

        for (int a = 0; a < 9; a += 3) {
            for (int b = 0; b < 9; b += 3) {
                for (int i = a; i < a + 3; i++) {
                    for (int j = b; j < b + 3; j++) {
                        if (board[i][j] == '.') continue;
                        if (!set1.add(board[i][j])) {
                            System.out.println(i + ", " + j);
                            return false;
                        }
                    }
                }
                set1.clear();
            }
        }

        return true;
    }

    /**
     * References: https://discuss.leetcode.com/topic/8241/my-short-solution-by-c-o-n2/13
     */
    public boolean myBetter(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    int numIndex = num - 1;
                    int boxIndex = i / 3 * 3 + j / 3;
                    if (row[i][numIndex] || col[j][numIndex] || box[boxIndex][numIndex]) {
                        return false;
                    }
                    row[i][numIndex] = col[j][numIndex] = box[boxIndex][numIndex] = true;
                }
            }
        }
        return true;
    }

}
