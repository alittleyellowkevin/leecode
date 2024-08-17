package stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class 下一个更大的元素Ⅰ {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums2.length == 1 ){
            return new int[]{-1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack =  new Stack<>();
        stack.add(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.add(nums2[i]);
        }
        while (!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

}
