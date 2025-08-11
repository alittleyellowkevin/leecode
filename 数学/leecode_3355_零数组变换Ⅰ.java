package 数学;

public class leecode_3355_零数组变换Ⅰ {
    public static void main(String[] args) {

    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] deleteArray = new int[nums.length + 1];
        //1.构建差分数组
        for(int[] querie:queries){
            deleteArray[querie[0]]++;
            deleteArray[querie[1]+1]--;
        }
        //2.构建每个num 需减多少
        for(int i=1; i<deleteArray.length; i++){
            deleteArray[i] = deleteArray[i] + deleteArray[i-1];
        }

        //3.计算
        for(int i=0; i<nums.length; i++){
            if(nums[i] - deleteArray[i] >0){
                return false;
            }
        }
        return true;
    }
}
