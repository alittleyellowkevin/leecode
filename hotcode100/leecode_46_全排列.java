package hotcode100;

import java.util.*;
import java.util.stream.Collectors;

public class leecode_46_全排列 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        generate(nums, set, list);
        return result;
    }

    private void generate(int[] nums, Set<Integer> set, List<Integer> list) {
        if (list.size() == nums.length) {
            List<Integer> newList = new ArrayList<>();
            result.add(newList);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])){
                    list.add(nums[i]);
                    set.add(nums[i]);
                    generate(nums, set, list);
                    set.remove(nums[i]);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
