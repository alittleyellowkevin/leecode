package array;

public class 移动0 {
    public void moveZeroes(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                number ++;
            }else{
                nums[i-number] = nums[i];
            }
        }
        for(int i = 0; i < number; i++){
            nums[nums.length-i-1] = 0;
        }
    }
}
