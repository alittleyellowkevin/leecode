package 位运算;

public class leecode_136_只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
