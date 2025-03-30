package array;

import java.util.HashSet;
import java.util.Set;

public class leecode_349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> myset = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if(!myset.contains(nums1[i])){
                myset.add(nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(myset.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    // 修改2：将res.toArray()修改为res.stream().mapToInt(Integer::intValue).toArray()
}
