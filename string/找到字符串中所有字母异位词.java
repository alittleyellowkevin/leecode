package string;

import java.util.ArrayList;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if(isAnagram(s.substring(i, p.length()), p)){
                res.add(i);
            }
        }
        return res;
    }
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)-'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
