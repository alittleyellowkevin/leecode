package stack;

public class 验证回文串 {
    public static void main(String[] args) {
        char s = 'A';
        System.out.println((char)(s+32));
    }
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        s = s.toUpperCase();
        while(start<end){
            if(!isZimu(s.charAt(start))){
                start = start+1;
                continue;
            }
            if(!isZimu(s.charAt(end))){
                end = end-1;
                continue;
            }
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else {
                return false;
            }
        }
        return true;
    }
    public static boolean isZimu(char str){
        return str>='a' && str<='z' || str>='A'&&str<='Z' || str>='0' && str<='9';
    }
}
