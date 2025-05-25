package 字符串;

public class 正则表达式 {
    public static void main(String[] args) {
        isMatch("aa", "a*");
    }
    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        while (i<s.length()){
            char one = s.charAt(i);
            if(j>=p.length())return false;
            char two = p.charAt(j);
            if(two<='z' && two>='a') {
                if(one != two){
                    if(j+1<p.length() && p.charAt(j+1) == '*'){
                        j++;
                        i--;
                    }else {
                        return false;
                    }
                }
            } else if (two == '*') {
                if(p.charAt(j-1) == '.'){
                    return true;
                } else if (p.charAt(j-1) == s.charAt(i)) {
                    j--;
                } else if (j+1<p.length()) {
                    i--;
                }else {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }
}
