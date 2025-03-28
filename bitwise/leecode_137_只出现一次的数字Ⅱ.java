package bitwise;

public class leecode_137_只出现一次的数字Ⅱ {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += ((nums[j]>>i) & 1) ;
            }
            if(count % 3 == 1) res |= (1<<i);
        }
        return res;
    }
}
