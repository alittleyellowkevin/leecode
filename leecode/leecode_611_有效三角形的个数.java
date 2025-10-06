package leecode;

import java.util.Arrays;

public class leecode_611_有效三角形的个数 {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int a=0; a<nums.length-2; a++){
            for(int b=a+1; b<nums.length-1; b++){
                int c = b+1;
                while (c < nums.length && isValidTriAngle(nums[a], nums[b], nums[c])){
                    count++;
                    c++;
                }
            }
        }
        return count;
    }

    public boolean isValidTriAngle(int a, int b, int c){
        return (a+b > c) && (c-b < a);
    }
}
