package hotcode100;

import java.util.*;
import java.util.stream.Collectors;

public class leecode_78_子集 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new LinkedList<>();
        generate(nums, 0, list);
        return result;
    }

    private void generate(int[] nums, int start, List<Integer> list) {
        if (start > nums.length) {
            return;
        }
        List<Integer> newList = list.stream().collect(Collectors.toList());
        result.add(newList);
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            generate(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
