package leecode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leecode_3_无重复字符的最长子串 {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, set.size());
        }
        return max;
    }
}
