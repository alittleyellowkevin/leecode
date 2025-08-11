package hotcode100;

public class leecode_41_缺失的第一个正数 {
    public static void main(String[] args) {
        firstMissingPositive(new int[]{2,1,1,0,3,0,4,3,2});
    }
    public static int firstMissingPositive(int[] nums) {
        //首先将所有负数设置为0
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }

        //将当前所有正数对应位置的数字变为负数
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                continue;
            }
            int position = (nums[i] < 0 ? -nums[i]:nums[i]) - 1;
            if(position < nums.length && nums[position] >=0 && nums[position] != position+1) {
                nums[position] = (nums[position] == 0 ? position+1 : -nums[position]);
            }
        }

        //最后顺序查找
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= 0 && nums[i] != (i+1)){
                return i+1;
            }
        }
        return nums.length+1;
    }
}
