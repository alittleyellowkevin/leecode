package stack;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {4, 5, 3, 2, 1};
        IsPopOrder(nums1, nums2);
    }
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i<pushV.length && j<popV.length){
            stack.add(pushV[i]);
            i++;
            while (!stack.isEmpty() && stack.peek() == popV[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty()? true:false;
    }
}
