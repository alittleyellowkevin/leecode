package 线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_350_两个数组的交集Ⅱ {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] numbers1 = new int[1001];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            numbers1[nums1[i]] += 1;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (numbers1[nums2[i]] > 0) {
                numbers1[nums2[i]] -= 1;
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class 四数之和 {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }

    }
}
