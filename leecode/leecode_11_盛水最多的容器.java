package leecode;

public class leecode_11_盛水最多的容器 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while (i<j){
            max = Math.max((j-i) * Math.min(height[i], height[j]), max);
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return max;
    }
}
