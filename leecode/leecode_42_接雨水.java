package leecode;

import java.util.Map;

public class leecode_42_接雨水 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int result = 0;
        int l = 0;
        int r = height.length-1;
        int lmax = 0;
        int rmax = 0;
        while (l<r){
            lmax = Math.max(height[l], lmax);
            rmax = Math.max(height[r], rmax);
            if(rmax>lmax){
                result += lmax - height[l];
                l++;
            }else {
                result += rmax - height[r];
                r--;
            }
        }
        return result;
    }
}
