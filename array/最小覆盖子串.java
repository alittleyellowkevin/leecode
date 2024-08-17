package array;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {
//    输入：s = "ADOBECODEBANC", t = "ABC"
//    输出："BANC"
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.replace(t.charAt(i), map.get(t.charAt(i)) + 1);
            }else {
                map.put(t.charAt(i), 1);
            }
        }
        Map<Character, Integer> map_ = new HashMap<>();
        int i = 0;
        int j = 0;
        while (j<s.length()){

        }
        return s;
    }
}
