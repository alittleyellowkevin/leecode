package 线性表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leecode_15_三数之和 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, 4 };
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int start = 0, mid, end;
        for (start = 0; start < nums.length - 2; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }
            mid = start + 1;
            end = nums.length - 1;
            while (mid < end) {
                if (nums[start] + nums[mid] + nums[end] > 0) {
                    end = end - 1;
                    while (end < nums.length - 1 && mid < end && nums[end] == nums[end + 1]) {
                        end = end - 1;
                    }
                } else if (nums[start] + nums[mid] + nums[end] < 0) {
                    mid = mid + 1;
                    while (mid > start + 1 && mid < end && nums[mid] == nums[mid - 1]) {
                        mid = mid + 1;
                    }
                } else {
                    List<Integer> number = new ArrayList<>();
                    number.add(nums[start]);
                    number.add(nums[mid]);
                    number.add(nums[end]);
                    res.add(number);
                    mid = mid + 1;
                    while (mid > start + 1 && mid < end && nums[mid] == nums[mid - 1]) {
                        mid = mid + 1;
                    }
                }
            }
        }
        return res;
    }

}
