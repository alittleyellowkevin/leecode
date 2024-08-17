package number;

import java.util.Arrays;

public class 最接近的三数之和_leecode_16 {
    public static void main(String[] args) {
        int[] list = {-1, 2, 1, -4 };
        System.out.println(threeSumClosest(list, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }
    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res=0;
        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if(j != i+1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                if(k != nums.length-1 && nums[k] == nums[k+1]){
                    k--;
                    continue;
                }
                int number = nums[i] + nums[j] + nums[k];

                if(number - target>0){
                    k--;
                    if(number - target < min){
                        min = number - target;
                        res = number;
                    }
                } else if (number - target < 0) {
                    j++;
                    if(target - number < min){
                        min = target - number;
                        res = number;
                    }
                }else {
                    return target;
                }
            }
        }
        return res;
    }
}
