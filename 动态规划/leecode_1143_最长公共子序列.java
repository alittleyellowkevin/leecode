package 动态规划;

public class leecode_1143_最长公共子序列 {
    public static void main(String[] args) {
        longestCommonSubsequence("abcde", "ace");
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        // 表示longestList[i][j]表示以0~i 的 text1 以及 0~j的 text2的最长公共子序列长度
        int[][] longgestList = new int[text1.length() + 1][text2.length() + 1];

        // 无需初始化

        // 开始循环
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                char a = text1.charAt(i - 1);
                char b = text2.charAt(j - 1);
                // 如果当前 a = b, 则 longgest[i][j] = longgest[i-1][j-1] + 1
                if (a == b) {
                    longgestList[i][j] = longgestList[i - 1][j - 1] + 1;
                } else {
                    longgestList[i][j] = Math.max(longgestList[i - 1][j], longgestList[i][j - 1]);
                }
            }
        }

        return longgestList[text1.length()][text2.length()];
    }
}
