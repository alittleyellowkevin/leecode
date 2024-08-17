package dynamic;

public class 最后的一块石头的重量Ⅱ {
    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        lastStoneWeightII(stones);
    }
    //
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int num : stones) {
            sum += num;
        }
        boolean[] res = new boolean[sum/2+1];

        //初始化
        res[0] = true;
        //递推
        for (int i = 0; i < stones.length; i++) {
            for (int j = res.length-1; j >= stones[i]; j--) {
                res[j] = res[j-stones[i]]==true ?true:res[j];
            }
        }
        int i = sum/2;
        while (res[i] == false){
            i--;
        }
        return sum - 2*i;
    }

}
