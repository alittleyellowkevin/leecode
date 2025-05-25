package 动态规划;

public class leecode_38_外观数列 {
    public static void main(String[] args) {
        String s = countAndSay(4);
        System.out.println(s);
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            return du(countAndSay(n - 1));
        }
    }

    public static String du(String number) {
        StringBuffer sb = new StringBuffer();
        int count = 1;

        if (number.length() == 1) {
            return "11";
        }
        for (int i = 0; i < number.length() - 1; i++) {
            if (i == number.length() - 2) {
                if (number.charAt(i) == number.charAt(i + 1)) {
                    count = count + 1;
                    sb.append(count);
                    sb.append(number.charAt(i));
                } else {
                    sb.append(count);
                    sb.append(number.charAt(i));
                    sb.append(1);
                    sb.append(number.charAt(i + 1));
                }
                break;
            }
            if (number.charAt(i) == number.charAt(i + 1)) {
                count = count + 1;
            } else {
                sb.append(count);
                sb.append(number.charAt(i));
                count = 1;
            }
        }
        return sb.toString();
    }
}
