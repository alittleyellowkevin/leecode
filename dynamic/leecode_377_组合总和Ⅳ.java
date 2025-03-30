package dynamic;

import java.util.ArrayList;
import java.util.List;

public class leecode_377_组合总和Ⅳ {
    public static void main(String[] args) {
    }

    public static int combinationSum4(int[] nums, int target) {
        //1. 确定数组大小，以及数组所代表含义
        int[] res = new int[target+1];
        //2. 确定数组的初始值 -- 默认 res [0] = 0;
        //3. 确定数组的遍历顺序
        for(int i = 1; i <= target; i++){
            for(int num : nums){
                if(num == i){
                    res[i] += 1;
                }else if(num < i){
                    res[i] += res[i-num];
                }
            }
        }
        return res[target];
    }


}
