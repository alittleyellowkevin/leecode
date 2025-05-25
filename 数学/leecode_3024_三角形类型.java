package 数学;

public class leecode_3024_三角形类型 {
    public String triangleType(int[] nums) {
        if (nums[0] + nums[1] > nums[2] && Math.max(nums[0], nums[1]) - Math.min(nums[0], nums[1]) < nums[2]) {
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
                return "isosceles";
            } else {
                return "scalene";
            }
        }
        return "none";
    }
}
