package 动态规划;

public class leecode_96_不同的二叉搜索树 {
    public static void main(String[] args) {

    }

    public static int numTrees(int n) {
        // 1. nums[i] 表示 有i个节点时树的种类

        int[] numbers = new int[n + 1];
        // 2.初始化将 0颗树设置为1 1颗树也设置为1
        numbers[0] = 1;
        numbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            int left = 0;
            int right = i - 1;
            int sum = 0;
            // 3.递推公式：将num[i] = num[i-2] * num[0] + num[i-3] * num[1] ....
            while (left < i) {
                sum = sum + numbers[left] * numbers[right];
                left++;
                right--;
            }
            numbers[i] = sum;
        }
        return numbers[n];
    }
}
