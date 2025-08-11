package 字符串;

import java.util.Map;

public class leecode_3443_K次修改后的最大曼哈顿距离 {
    public int maxDistance(String s, int k) {
        int leftRight = 0;
        int upDown = 0;
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'N'){
                upDown++;
            } else if (c == 'S') {
                upDown--;
            } else if (c == 'E') {
                leftRight++;
            } else  {
                leftRight--;
            }
            int currentLen = (leftRight<0?-leftRight:leftRight) + (upDown<0?-upDown:upDown);
            count = (i + 1 - (currentLen))/2;
            if(count>=k){
                maxLength = Math.max(maxLength, currentLen + 2*k);
            }else {
                maxLength = Math.max(maxLength, currentLen + 2*count);
            }
        }
        return maxLength;
    }
}
