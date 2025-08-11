package 线性表;

import java.util.ArrayList;
import java.util.List;

public class leecode_386_字典序排数 {
    public static void main(String[] args) {

    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=n; i++){
            result.add(i);
        }
        result.sort((a, b)->
            String.valueOf(a).compareTo(String.valueOf(b))
        );
        return  result;
    }
}
