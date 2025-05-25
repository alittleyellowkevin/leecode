package 字符串;

public class leecode_394_字符串解码 {
    public static void main(String[] args) {
        decodeString("100[leetcode]");
    }

    public static String decodeString(String s) {
        StringBuffer sb = new StringBuffer();
        // 四种字符
        for (int i = 0; i < s.length(); i++) {
            // 当前字母
            char currentChar = s.charAt(i);

            // 当前字母如果是数字
            if (Character.isDigit(currentChar)) {
                // 数字部分大小
                int sum = 0;
                sum += (int) (currentChar - '0');
                i++;
                currentChar = s.charAt(i);
                while (Character.isDigit(currentChar)) {
                    sum = sum * 10 + (int) (currentChar - '0');
                    i++;
                    currentChar = s.charAt(i);
                }

                // 去除括号,将当前左括号个数设置为1
                int count = 1;
                i++; // 跳过左括号
                int start = i; // 左括号后第一个位置
                while (i < s.length() && count != 0) {
                    char cnext = s.charAt(i);
                    if (cnext == ']') {
                        count--;
                    }
                    if (cnext == '[') {
                        count++;
                    }
                    i++;
                }
                i--;
                int end = i;// 右括号的位置
                String subString = decodeString(s.substring(start, end)); // 遍历处理
                for (int j = 0; j < sum; j++) {
                    sb.append(subString);
                }
            }
            // 当为字母时
            else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
}
