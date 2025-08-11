package hotcode100;

public class leecode_42_接雨水 {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        int result = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(height[left]> height[right]){
                result += (rightMax - height[right]);
                right--;
            }else {
                result += (leftMax - height[left]);
                left++;
            }
        }
        return result;
    }
}
