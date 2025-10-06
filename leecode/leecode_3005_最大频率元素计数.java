package leecode;

public class leecode_3005_最大频率元素计数 {
    public int maxFrequencyElements(int[] nums) {
        int[] array = new int[101];
        int max = 0;
        int count = 0;
        for (int num : nums) {
            array[num]++;
            if (max < array[num]) {
                max = array[num];
                count = 1;
            }else if (max == array[num]) {
                count++;
            }
        }
        return count * max;
    }
}
