package hotcode100;

public class leecode_79_单词搜索 {
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    flag = flag || search(board, i, j, word, 0);
                }
            }
        }
        return flag;
    }

    private boolean search(char[][] board, int l, int r, String word, int i) {
        boolean flag = false;
        if(l>=0 && l<board.length && r>=0 && r<board[0].length && board[l][r] == word.charAt(i)){
            flag = flag || search(board, l+1, r, word, i+1);
            flag = flag || search(board, l-1, r, word, i+1);
            flag = flag || search(board, l, r+1, word, i+1);
            flag = flag || search(board, l, r-1, word, i+1);
        }
        return flag;
    }
}
