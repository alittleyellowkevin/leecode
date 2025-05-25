package 字符串;

public class leecode_3274_检查棋盘方格颜色是否相同 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int coordinate1Char = coordinate1.charAt(0) - 'a';
        int coordinate1Int = coordinate1.charAt(1) - '0';
        int coordinate2Char = coordinate2.charAt(0) - 'a';
        int coordinate2Int = coordinate2.charAt(1) - '0';
        return ((coordinate1Char + coordinate1Int) % 2) == ((coordinate2Int + coordinate2Char) % 2);
    }
}
