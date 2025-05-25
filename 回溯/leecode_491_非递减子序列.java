package 回溯;

import java.util.*;

public class leecode_491_非递减子序列 {
    public static void main(String[] args) {
        int[] nums = { 4, 6, 7, 7 };
        findSubsequences(nums);

    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        back(res, path, 0, nums);
        return res;
    }

    private static void back(List<List<Integer>> res, ArrayList<Integer> path, int i, int[] nums) {
        if (path.size() > 1) {
            res.add((List<Integer>) path.clone());
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (!set.contains(nums[j])) {
                if (path.size() == 0) {
                    set.add(nums[j]);
                    path.add(nums[j]);
                    back(res, path, j + 1, nums);
                    path.remove(path.size() - 1);
                } else {
                    if (nums[j] >= path.get(path.size() - 1)) {
                        set.add(nums[j]);
                        path.add(nums[j]);
                        back(res, path, j + 1, nums);
                        path.remove(path.size() - 1);
                    }
                }
            }

        }
    }
}
