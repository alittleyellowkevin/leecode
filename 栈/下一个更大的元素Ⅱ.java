package 栈;

import java.util.LinkedList;

public class 下一个更大的元素Ⅱ {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        nextGreaterElements(nums);
    }
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 2*nums.length; i++) {
            //对第j个节点进行处理
            int j = i % nums.length;
            if(list.isEmpty()){
                list.add(j);
            }else {
                while (!list.isEmpty() && nums[j] > nums[list.getLast()]){
                    res[list.getLast()] = nums[j];
                    list.removeLast();
                }
                list.add(j);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(res[i] == Integer.MAX_VALUE){
                res[i] = -1;
            }
        }
        return res;
    }
}
