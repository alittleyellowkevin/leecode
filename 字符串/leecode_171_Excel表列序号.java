package 字符串;

public class leecode_171_Excel表列序号 {
    public static void main(String[] args) {

    }
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = (res + columnTitle.charAt(i) - 'A' + 1)*((int)Math.pow(26, columnTitle.length()-i-1));
        }
        return res;
    }
}
