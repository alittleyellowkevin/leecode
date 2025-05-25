package 字符串;

public class 找出字符串中第一个匹配项的下标 {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        String s1 = "aabaabaaf";

    }
    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int i = 0;
        int j = 0;
        while (i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                if(j == 0){
                    i++;
                }else {
                    j = next[j-1];
                }
            }
        }
        if(j == needle.length()){
            return i-j;
        }else {
            return -1;
        }
    }
    public static void getNext(int[] next, String s){
        // (0, j)前缀， (1, i)后缀
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j>0 && s.charAt(i) !=s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
