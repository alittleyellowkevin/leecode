package leecode;

import java.util.Stack;

public class leecode_84_柱状图中最大的矩形 {
    public static int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i]; // 当前高度

            while (!stack.isEmpty() && height < stack.peek()[0]) {
                if (stack.size() == 1) {
                    int[] peekPop = stack.pop();
                    maxArea = Math.max(maxArea, i * peekPop[0]);
                } else {
                    int[] peekPop = stack.pop();
                    int[] peek = stack.peek();
                    maxArea = Math.max(maxArea, (i - peek[1] - 1) * peekPop[0]);
                }
            }

            stack.push(new int[] { height, i });
        }

        // 清空栈
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                int[] peek = stack.pop();
                maxArea = Math.max(maxArea, peek[0] * heights.length);
            } else {
                int[] peekPop = stack.pop();
                int[] peek = stack.peek();
                maxArea = Math.max(maxArea, (heights.length - peek[1] - 1) * peekPop[0]);
            }
        }

        return maxArea;
    }
}
