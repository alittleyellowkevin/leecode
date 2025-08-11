package 数学;

public class leecode_2894_分类求和并作差 {
    public int differenceOfSums(int n, int m) {
        int i = 1;
        int sum = 0;
        while(i<=n){
            if(i%m == 0){
                sum-=i;
            }else{
                sum+=i;
            }
            i++;
        }
        return sum;
    }
}
