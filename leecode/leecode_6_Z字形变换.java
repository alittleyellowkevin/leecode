package leecode;

public class leecode_6_Z字形变换 {
    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
    public static String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        int k = numRows*2 -2;
        if(numRows == 1){
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index <= s.length()-1){
                result.append(s.charAt(index));
                int another = ((index/k)+1) *k - i;
                if(another <= s.length()-1 && i<numRows-1 && i>0){
                    result.append(s.charAt(another));
                }
                index += k;
            }
        }
        return result.toString();
    }
}
