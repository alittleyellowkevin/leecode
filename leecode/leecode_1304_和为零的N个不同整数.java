package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_1304_和为零的N个不同整数 {
    public int[] sumZero(int n) {
        List<Integer>  result = new ArrayList<>();
        if(n % 2 == 1){
            result.add(0);
            n--;
        }
        for(int i=1; i<=n/2; i++){
            result.add(i);
            result.add(-i);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
