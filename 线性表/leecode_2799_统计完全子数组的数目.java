package 线性表;

import java.util.HashMap;

public class leecode_2799_统计完全子数组的数目 {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> totalCount = new HashMap<>();
        for (int num : nums) {
            totalCount.put(num, totalCount.getOrDefault(num, 0) + 1);
        }
        int distinctCount = totalCount.size();

        int result = 0;
        int left = 0;
        HashMap<Integer, Integer> windowCount = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            windowCount.put(nums[right], windowCount.getOrDefault(nums[right], 0) + 1);

            while (windowCount.size() == distinctCount) {
                result += nums.length - right;
                windowCount.put(nums[left], windowCount.get(nums[left]) - 1);
                if (windowCount.get(nums[left]) == 0) {
                    windowCount.remove(nums[left]);
                }
                left++;
            }
        }

        return result;
    }
}
