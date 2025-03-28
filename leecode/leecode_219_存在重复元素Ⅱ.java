package leecode;

import java.util.HashSet;
import java.util.Set;

public class leecode_219_存在重复元素Ⅱ {
    // 暴力解法
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0){
            return false;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j] && j - i <= k){
                    return true;
                }
            }
        }
        return false;
    }

    // 哈希表
    public boolean hashcontainsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
