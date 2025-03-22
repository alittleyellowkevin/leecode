package leecode;

import java.util.HashMap;
import java.util.Map;

public class leecode_76_最小覆盖子串 {
    public static void main(String[] args) {
        minWindow("ADOBECODEBANC", "ABC");
    }
    public static String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int resultSize = Integer.MAX_VALUE;
        String result = "";
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
            }else {
                tMap.put(t.charAt(i), 1);
            }
        }
        if(tMap.containsKey(s.charAt(0))){
            sMap.put(s.charAt(0), 1);
        }
        while (start <= end && end < s.length()){
            if(compare(sMap, tMap)){
                //此时字符串包含所有字符
                if((end - start + 1) < resultSize){
                    resultSize = end - start + 1;
                    result = s.substring(start, end+1);
                }
                char key = s.charAt(start);
                if(sMap.containsKey(key)){
                    sMap.put(key, sMap.get(key)-1);
                }
                start++;
            }else {
                //此时字符串不包含所有字符
                //判断end下一个字母是否需要加入到sMap
                if(end+1 < s.length() && tMap.containsKey(s.charAt(end+1))){
                    //判断sMap中是否有该字母
                    if(sMap.containsKey(s.charAt(end+1))){
                        //如果包含
                        sMap.put(s.charAt(end+1), sMap.get(s.charAt(end+1)) + 1);
                    }else {
                        //如果不包含
                        sMap.put(s.charAt(end+1), 1);
                    }
                }
                end++;
            }
        }
        return result;
    }

    private static boolean compare(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        boolean flag = true;
        for (Character key : tMap.keySet()) {
            if (sMap.containsKey(key) && sMap.get(key) >= tMap.get(key)){
            }else {
                flag = false;
            }
        }
        return flag;
    }
}
