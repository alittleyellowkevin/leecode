package leecode;

public class leecode_65_有效数字 {
    public static void main(String[] args) {
        isNumber("+.8");
    }
    public static boolean isNumber(String s) {
        int index = -1;
        int epo = s.indexOf("e");
        int Epo = s.indexOf("E");
        index = epo != -1 ? epo:index;
        index = Epo != -1 ? Epo:index;
        if(index == -1){
            return isShiJinZhi(s);
        } else if (index == s.length()-1 || index == 0) {
            return false;
        } else {
            return isShiJinZhi(s.substring(0, index)) && isZhengShu(s.substring(index+1));
        }
    }
    public static boolean isShuZi(String s){
        if(s.length() == 0){
            return false;
        }
        int i = 0;
        while (i < s.length()){
            if(s.charAt(i)<'0' || s.charAt(i)>'9'){
                return false;
            }
            i++;
        }
        return true;
    }
    public static boolean isZhengShu(String s){
        int i = 0;
        if(s.charAt(0) == '+'|| s.charAt(0) == '-'){
            return isShuZi(s.substring(1));
        }else {
            return isShuZi(s);
        }
    }

    public static boolean isShiJinZhi(String s){
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1);
        }
        int index = s.indexOf(".");
        if(index == -1){
            return isShuZi(s);
        }else {
            if(index == 0){
                return isShuZi(s.substring(1));
            } else if (index == s.length()-1) {
                return isShuZi(s.substring(0, s.length()-1));
            }else {
                return isShuZi(s.substring(0, index)) && isShuZi(s.substring(index+1));
            }
        }
    }
}
