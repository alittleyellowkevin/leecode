package leecode;

public class leecode_2348_全0子数组的数目 {
    public long zeroFilledSubarray(int[] nums) {
        long[] array = new long[nums.length+1];
        array[1] = 1;
        for(int i=2; i<array.length; i++){
            array[i] = array[i-1] + i;
        }

        long sum = 0;
        int leftZero = -1;
        int rightZero = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                if(leftZero == -1){
                    leftZero = i;
                }
                rightZero = i;
            }else{
                if(leftZero != -1){
                    sum += array[rightZero - leftZero + 1];
                    leftZero = -1;
                    rightZero = -1;
                }
            }
        }
        long tail = (leftZero != -1) ? array[rightZero - leftZero + 1] : 0;
        return sum + tail ;
    }
}
