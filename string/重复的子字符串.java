package string;

public class 重复的子字符串 {
    public static void main(String[] args) {
        repeatedSubstringPattern2("aba");
    }
    //方法一 2
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s, 1) != s.length();

    }
    public static boolean repeatedSubstringPattern2(String s) {
        return kmp((s + s).substring(1, 2 * s.length()-1), s) != -1;
    }

    private static int kmp(String substring, String s) {
        int[] next = new int[s.length()];
        getNext(next, s);
        int i = 0;
        int j = 0;
        while (i<substring.length() && j<s.length()){
            if(substring.charAt(i) == s.charAt(j)){
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
        if(j==s.length()){
            return i-j;
        }else {
            return -1;
        }
    }

    public static void getNext(int[] next, String s){
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j>0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }
}
