package leecode;

public class leecode_66_加一 {
    public static void main(String[] args) {
    }
    public static int[] plusOne(int[] digits) {
        StringBuffer sb = new StringBuffer();
        int step = 1;
        for (int i = digits.length-1; i >= 0; i--) {
            int number = digits[i];
            number += step;
            step = number/10;
            number = number%10;
            sb.append((number));
        }
        if(step != 0){
            sb.append((step));
        }
        int[] result = new int[sb.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sb.charAt(result.length-i-1) - '0';
        }
        return result;
    }
}
