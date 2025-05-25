package 字符串;

import java.util.*;

public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length()-10; i++) {
            if(map.containsKey(s.substring(i,i+10))){
                map.put(s.substring(i, i+10), map.get(s.substring(i, i+10)) + 1);
                if(map.get(s.substring(i, i+10)) == 2){
                    res.add(s.substring(i, i+10));
                }
            }else {
                map.put(s.substring(i, i+10), 1);
            }
        }
        return res;
    }

}
