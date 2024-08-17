package leecode;

import java.util.Map;

public class leecode_38_外观数列 {
    public static void main(String[] args) {
        countAndSay(4);
    }
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }else {
            return code(countAndSay(n-1));
        }
    }

    private static String code(String s) {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(i>0){
                if(s.charAt(i) == s.charAt(i-1)){
                    count++;
                }else {
                    sb.append((char) ('0'+count));
                    sb.append(s.charAt(i-1));
                    count = 1;
                }
            }else {
                count++;
            }
        }
        if(count!=0){
            sb.append((char) ('0'+count));
            sb.append(s.charAt(s.length()-1));
        }
        return sb.toString();
    }
}
