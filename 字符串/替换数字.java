package 字符串;

public class 替换数字 {
    public static String changeNumber(String s){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                sb.append("number");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
