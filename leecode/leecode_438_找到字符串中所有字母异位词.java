package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        findAnagrams(s, p);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] pMode = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pMode[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length()-p.length()+1; i++) {
            boolean flag = true;
            int[] sMode = new int[26];
            for (int j = i; j < i+p.length(); j++) {
                sMode[s.charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                flag = flag && (sMode[j] == pMode[j]);
            }
            if (flag){
                result.add(i);
            }
        }
        return result;
    }
}
