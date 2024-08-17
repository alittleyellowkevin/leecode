package leecode;

public class leecode_67_二进制求和 {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int step = 0;
        StringBuffer sb = new StringBuffer();
        while (i>=0 || j>=0){
            int fir = i>=0? a.charAt(i) - '0':0;
            int sec = j>=0? b.charAt(j) - '0':0;
            char number = (char) ('0'+(fir+sec+step)%2);
            sb.append(number);
            step = (fir + sec + step)/2;
            i--;
            j--;
        }
        if(step!=0){
            sb.append((char)('0' + step));
        }
        return sb.reverse().toString();
    }
}
