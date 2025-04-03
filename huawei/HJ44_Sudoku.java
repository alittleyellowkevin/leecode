package huawei;

import java.util.Scanner;

public class HJ44_Sudoku {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int[][] board = new int[9][9];
            // 读取数独矩阵
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    board[i][j] = in.nextInt();
                }
            }
            
            solveSudoku(board);
            
            // 输出结果
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                    if (j < 8) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
    
    private static boolean solveSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // 检查行
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) return false;
        }
        
        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }
        
        // 检查3x3方格
        int boxRow = row - row % 3;
        int boxCol = col - col % 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        
        return true;
    }
}
