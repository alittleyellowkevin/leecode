package 数学;

public class leecode_2566_替换一个数字后的最大差值 {
    public int minMaxDifference(int num) {
        //1. 找到最大值
        String nums = String.valueOf(num);

        char minChar = nums.charAt(0);
        char maxChar = nums.charAt(0);
        for(int i=0; i<nums.length(); i++){
            if(nums.charAt(i) < '9'){
                maxChar = nums.charAt(i);
                break;
            }
        }
        String maxNum = nums.replace(maxChar, '9');
        String minNum = nums.replace(minChar, '0');
        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);

    }
}
