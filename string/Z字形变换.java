package string;

public class Z字形变换 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        convert(s, 3);
    }
    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuffer sb = new StringBuffer();
        int T = 2*numRows -2;
        for (int i = 0; i < numRows; i++) {
            if(i > 0 && i<numRows-1){
                for (int j = i; j < s.length(); j+=T) {
                    sb.append(s.charAt(j));
                    if( j - i + (T-i)  < s.length()){
                        sb.append(s.charAt(j - i + (T-i)));
                    }
                }
            }else {
                for (int j = i; j < s.length(); j+=T) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
