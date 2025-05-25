package 栈;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 滑动窗口最大值 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(nums, 3);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        int i = 0;
        while (i<k){
            while (!deque.isEmpty() && nums[i] > deque.getLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            i++;
        }
        if(nums.length<=k){
            return new int[]{deque.getFirst()};
        }
        res.add(deque.getFirst());
        while (i<nums.length){
            while (!deque.isEmpty() && nums[i] > deque.getLast()){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if(deque.getFirst() == nums[i-k]){
                deque.removeFirst();
            }
            res.add(deque.getFirst());
            i++;
        }
        int[] result = new int[res.size()];
        for(int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }
}
