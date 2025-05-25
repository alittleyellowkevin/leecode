package 贪心;

import java.util.ArrayList;
import java.util.List;

public class 摆动序列 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        wiggleMaxLength(nums);
    }
    public static int wiggleMaxLength(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(res.size() == 0){
                res.add(nums[i]);
            } else if (nums[i] == res.get(res.size()-1)) {
                continue;
            }else {
                if(res.size()>=2){
                    if(different(res.get(res.size()-2), res.get(res.size()-1), nums[i])){
                        res.add(nums[i]);
                    }else {
                        res.remove(res.size()-1);
                        res.add(nums[i]);
                    }
                }else {
                    res.add(nums[i]);
                }
            }
        }
        return res.size();
    }
    private static boolean different(int num1, int num2, int num3) {
        if((num1-num2>0 && num2-num3<0) || (num1-num2<0) && (num2-num3>0)){
            return true;
        }else {
            return false;
        }
    }
}
