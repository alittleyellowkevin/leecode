package huawei;

import java.util.Scanner;

public class HJ65_查找两个字符串ab中的最长公共子串 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            String result = findLongestCommonSubstring(str1, str2);
            System.out.println(result);
        }
    }

    private static String findLongestCommonSubstring(String str1, String str2) {
        // TODO: 实现查找最长公共子串的逻辑
        // 可以使用动态规划或滑动窗口方法
        // 动态规划方法：
        // 1. 创建dp[i][j]表示以str1[i-1]和str2[j-1]结尾的最长公共子串长度
        // 2. 如果str1[i-1] == str2[j-1]，则dp[i][j] = dp[i-1][j-1] + 1
        // 3. 否则dp[i][j] = 0
        // 4. 记录最大长度和对应的结束位置

        // 初始化变量
        int maxLength = 0;
        int endIndex = 0;

        int m = 0;
        int n = 0;
        // 创建动态规划数组
        if (str1.length() < str2.length()) {
            String mid = str2;
            str2 = str1;
            str1 = mid;
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // 填充dp数组
        for (int j = 1; j <= str2.length(); j++) {
            for (int i = 1; i <= str1.length(); i++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = j - 1;
                    }
                }
            }
        }

        // 返回最长公共子串
        return str2.substring(endIndex - maxLength + 1, endIndex + 1);
    }
}