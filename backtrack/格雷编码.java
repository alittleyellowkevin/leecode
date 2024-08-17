package backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 格雷编码 {
    public static void main(String[] args) {
        grayCode(2);
    }
    public static List<Integer> grayCode(int n) {
        int[] numbers = new int[n];
        List<Integer> res = new ArrayList<>();
        res.add(toNumber(numbers));
        changeOne(numbers, res, n);
        return res;
    }
    public static void changeOne(int[] numbers,List<Integer> res, int n){
        if(res.size() == (int)Math.pow(2, n)){
            return;
        }else {
            for (int i = 0; i < n; i++) {
                if(numbers[i] == 0){
                    numbers[i] = 1;
                    if(res.contains(toNumber(numbers))){
                        numbers[i] = 0;
                        continue;
                    }else {
                        res.add(toNumber(numbers));
                        changeOne(numbers, res, n);
                    }
                }else {
                    numbers[i] = 0;
                    if(res.contains(toNumber(numbers))){
                        numbers[i] = 1;
                        continue;
                    }else {
                        res.add(toNumber(numbers));
                        changeOne(numbers, res, n);
                    }
                }
            }
        }
    }
    public static int toNumber(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + (int) (nums[i] * Math.pow(2, nums.length-i-1));
        }
        return sum;
    }
}
