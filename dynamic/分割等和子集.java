package dynamic;

public class 分割等和子集 {
    public static void main(String[] args) {
        int[] numbers ={2,2,1,1};
        canPartition(numbers);
    }
    //dp[j]  表示当前j容量的背包是否能被装满

    //状态转移方程 dp[j] = dp[j-value[i]], 若dp[j-value[i]]可以被装满，
    // 则dp[j] + 物品i也可以被装满, 否则状态不改变

    //初始化将dp[0]设置为true就行

    //先循环

    public static boolean canPartition(int[] nums) {
        if(nums.length == 1)return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum % 2 == 1) return false;
        boolean[] res = new boolean[sum/2+1];

        //初始化
        res[0] = true;
        //递推
        for (int i = 0; i < nums.length; i++) {
            for (int j = res.length-1; j >= nums[i]; j--) {
                    res[j] = res[j-nums[i]]==true ?true:res[j];
            }
        }
        return res[sum/2];
    }
}
