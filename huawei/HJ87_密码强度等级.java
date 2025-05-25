package huawei;

import java.util.Scanner;

public class HJ87_密码强度等级 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String password = in.nextLine().trim();
            String strengthLevel = getPasswordStrength(password);
            System.out.println(strengthLevel);
        }
    }

    /**
     * 计算密码强度等级
     * 
     * @param password 输入的密码
     * @return 密码强度等级描述
     */
    private static String getPasswordStrength(String password) {
        // 计算密码的总得分
        int score = calculatePasswordScore(password);

        // 根据得分确定密码强度等级
        if (score >= 90) {
            return "VERY_SECURE";
        } else if (score >= 80) {
            return "SECURE";
        } else if (score >= 70) {
            return "VERY_STRONG";
        } else if (score >= 60) {
            return "STRONG";
        } else if (score >= 50) {
            return "AVERAGE";
        } else if (score >= 25) {
            return "WEAK";
        } else {
            return "VERY_WEAK";
        }
    }

    /**
     * 计算密码的得分
     * 
     * @param password 输入的密码
     * @return 密码的总得分
     */
    private static int calculatePasswordScore(String password) {
        int score = 0;

        // 1. 密码长度得分
        score += getLengthScore(password);

        // 2. 字母得分
        score += getLetterScore(password);

        // 3. 数字得分
        score += getDigitScore(password);

        // 4. 符号得分
        score += getSymbolScore(password);

        // 5. 奖励得分
        score += getRewardScore(password);

        return score;
    }

    /**
     * 计算密码长度得分
     */
    private static int getLengthScore(String password) {
        int length = password.length();
        if (length <= 4) {
            return 5;
        } else if (length <= 7) {
            return 10;
        } else {
            return 25;
        }
    }

    /**
     * 计算字母得分
     */
    private static int getLetterScore(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
        }

        if (hasUpperCase && hasLowerCase) {
            return 20;
        } else if (hasUpperCase || hasLowerCase) {
            return 10;
        } else {
            return 0;
        }
    }

    /**
     * 计算数字得分
     */
    private static int getDigitScore(String password) {
        int digitCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        if (digitCount > 1) {
            return 20;
        } else if (digitCount == 1) {
            return 10;
        } else {
            return 0;
        }
    }

    /**
     * 计算符号得分
     */
    private static int getSymbolScore(String password) {
        int symbolCount = 0;

        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                symbolCount++;
            }
        }

        if (symbolCount > 1) {
            return 25;
        } else if (symbolCount == 1) {
            return 10;
        } else {
            return 0;
        }
    }

    /**
     * 计算奖励得分
     */
    private static int getRewardScore(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
                hasLetter = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
                hasLetter = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }

        // 奖励分只取符合最多条件的那一种
        if (hasUpperCase && hasLowerCase && hasDigit && hasSymbol) {
            // 大小写字母、数字和符号
            return 5;
        } else if ((hasLetter && hasDigit && hasSymbol) || (hasUpperCase && hasLowerCase && hasDigit)) {
            // 字母、数字和符号
            return 3;
        } else if (hasLetter && hasDigit) {
            // 字母和数字
            return 2;
        }

        return 0;
    }
}