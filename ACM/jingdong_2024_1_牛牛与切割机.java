package ACM;
import java.util.*;

public class jingdong_2024_1_牛牛与切割机 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int arrayLength = in.nextInt();
        long[] array = new long[arrayLength];
        long sum = 0;
        for(int i=0; i<arrayLength; i++){
            array[i] = in.nextLong();
            sum += array[i];
        }
        long left = array[0];
        long right = sum - array[0];
        long result = left * right;
        for(int i=1; i<arrayLength-1; i++){
            left += array[i];
            right -= array[i];
            result = Math.min(left*right, result);
        }
        System.out.println(result);
    }
}
