package string;

public class 最后一个单词长度_leecode_58 {
    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(lengthOfLastWord(s));
    }
    public static int lengthOfLastWord(String s) {
        int count=0; // 最后一个单词后面的空格数
        for (int i = s.length()-1; i >=0; i--) {
            if(s.charAt(i) ==  ' '){
                count++;
            }
            else {
                break;
            }
        }
        int result=0;
        for (int i = 0; i < s.length() - count; i++) {
            if(s.charAt(i) == ' '){
                result=0;
            }else {
                result++;
            }
        }
        return result;
    }

}
