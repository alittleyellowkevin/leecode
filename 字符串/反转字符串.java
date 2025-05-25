package 字符串;

public class 反转字符串 {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while (i<j){
            change(i++, j--, s);
        }
    }

    private void change(int i, int j, char[] s) {
        char mid = s[i];
        s[i] = s[j];
        s[j] = mid;
    }
}
