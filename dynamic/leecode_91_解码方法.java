package dynamic;

import tree.二叉中序遍历;

public class leecode_91_解码方法 {
    public static void main(String[] args) {
        String s = "2611055971756562";
        numDecodings(s);
    }

    public static int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;

        int[] nums = new int[s.length() + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i < nums.length; i++) {
            if (s.charAt(i - 1) == '0') {
                if ('1' <= s.charAt(i - 2) && s.charAt(i - 2) <= '2') {
                    nums[i] = nums[i - 2];
                } else {
                    return 0;
                }
            } else {
                nums[i] = nums[i - 1] + ((s.charAt(i - 2) == '1'
                        || (s.charAt(i - 2) == '2' && '1' <= s.charAt(i - 1) && s.charAt(i - 1) <= '6')) ? nums[i - 2]
                                : 0);
            }
        }
        return nums[s.length()];
    }

}
