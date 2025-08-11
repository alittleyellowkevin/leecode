package 数学;

public class leecode_1432_改变一个整数能得到的最大差值 {
    public static void main(String[] args) {
        maxDiff(123456);
    }
    public static int maxDiff(int num) {
        String nums = String.valueOf(num);

        // 找到第一个小于9的数字进行替换
        char maxChar = nums.charAt(0);
        for(int i=0; i<nums.length(); i++){
            if(nums.charAt(i) < '9'){
                maxChar = nums.charAt(i);
                break;
            }
        }

        // 找到最小数，最小数在第一位时，不能为0
        char minChar = nums.charAt(0);
        for (int i = 0; i < nums.length(); i++) {
            if(i == 0 && nums.charAt(i) > '1') {
                minChar = nums.charAt(i);
                break;
            } else if (i>0 && nums.charAt(i) != '0' && nums.charAt(i) != '1') {
                minChar = nums.charAt(i);
                break;
            }
        }

        String maxNum = nums.replace(maxChar, '9');
        String minNum = nums.replace(minChar, (minChar==nums.charAt(0)?'1':'0'));
        return Integer.parseInt(maxNum) - Integer.parseInt(minNum);
    }
}
