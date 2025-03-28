package array;

public class LCR_006_两数之和Ⅱ输入有序数组 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while (i<j){
            if(numbers[i] + numbers[j] > target){
                j--;
            } else if (numbers[i] + numbers[j] <target) {
                i++;
            }else {
                return new int[]{i+1, j+1};
            }
        }
        return new int[]{1, 1};
    }
}
