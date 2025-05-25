package 字符串;

public class 反转字符串中的单词 {
    public static void main(String[] args) {
        reverseWords("1 2 3    45  ");
    }
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = strings.length-1; i >= 0; i--) {
            if(strings[i].equals("")){
                continue;
            }else {
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        if(sb.charAt(sb.length()-1) == ' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
