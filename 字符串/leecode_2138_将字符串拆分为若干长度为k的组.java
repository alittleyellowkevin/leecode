package 字符串;

import java.util.ArrayList;
import java.util.List;

public class leecode_2138_将字符串拆分为若干长度为k的组 {
    public String[] divideString(String s, int k, char fill) {
        while(s.length() % k != 0){
            s= s + fill;
        }
        List<String> results = new ArrayList<>();
        for(int i=0; i<s.length(); i+=k){
            results.add(s.substring(i, i+k));
        }
        return results.toArray(results.toArray(new String[0]));
    }
}
