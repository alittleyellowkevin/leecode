package leecode;

public class leecode_45_跳跃游戏Ⅱ {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
    public static int jump(int[] nums) {
        int i = 0;
        int count = 0;
        while (i<nums.length-1){
            int maxTag = 0;
            int maxStep = 0;
            for (int j = i+1; j <= i+nums[i] && j<nums.length; j++) {
                if(j == nums.length-1){
                    return count+1;
                }
                if(maxStep <= (j-i +nums[j])){
                    maxTag = j;
                    maxStep = j-i + nums[j];
                }
            }
            i = maxTag;
            count++;
        }
        return count;
    }
}
