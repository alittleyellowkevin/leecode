package leecode;

public class leecode_1780_判断一个数字是否可以表示为三的幂的和 {
    public boolean checkPowersOfThree(int n) {
        int count = 0;

        int sum = n;
        while(n>=3){
            n /= 3;
            count++;
        }
        int[] numberArray = new int[count+1];
        for(int i=0; i<=count; i++){
            numberArray[i] = (int)Math.pow(3, i);
        }
        while(count>=0){
            if(sum >= numberArray[count]){
                sum -= numberArray[count];
            }
            count--;
        }
        return sum==0;
    }
}
