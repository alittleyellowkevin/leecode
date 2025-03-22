package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_78_子集 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> reuslt = new ArrayList<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        backsort(buffer, reuslt, 0, nums);
        return reuslt;
    }
    private static void backsort(ArrayList<Integer> buffer, List<List<Integer>> reuslt, int i, int[] nums) {
        reuslt.add((ArrayList<Integer>)buffer.clone());
        for (int j = i; j < nums.length; j++) {
            buffer.add(nums[j]);
            backsort(buffer, reuslt, j+1, nums);
            buffer.remove(buffer.size()-1);
        }
    }
}
