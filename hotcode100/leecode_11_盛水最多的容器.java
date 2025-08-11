package hotcode100;

public class leecode_11_盛水最多的容器 {
    public int maxArea(int[] height) {
        int start =0;
        int end = height.length-1;
        int result = 0;
        while (start < end){
            result = Math.max(Math.min(height[start], height[end])*(end-start), result);
            if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }
        return result;
    }
}
