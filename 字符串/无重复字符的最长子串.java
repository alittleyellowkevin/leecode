package 字符串;

import java.util.*;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int j = 0;
        int res = 0;
        for (int i = -1; i < s.length(); i++) {
            //移除当前值
            if(i!=-1){
                set.remove(s.charAt(i));
            }
            while (j<s.length() && (!set.contains(s.charAt(j)))){
                set.add(s.charAt(j));
                res = Math.max(j-i+1, res);
                j++;
            }
        }
        return res;
    }
}
