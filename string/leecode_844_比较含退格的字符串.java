package string;

public class leecode_844_比较含退格的字符串 {
    public static boolean backspaceCompare(String s, String t) {
        String s1 = process(s);
        String s2 = process(t);

        if(s1.equals(s2)){
            return true;
        }else {
            return false;
        }
    }

    private static String process(String s) {
       StringBuffer sb = new StringBuffer();
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i) == '#'){
                if(sb.length() != 0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    //双指针
    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

}
