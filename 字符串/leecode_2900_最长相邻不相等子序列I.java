package 字符串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leecode_2900_最长相邻不相等子序列I {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String maxLeString = words[i];
            while (i + 1 < words.length && groups[i] == groups[i + 1]) {
                i++;
                if (words[i].length() > maxLeString.length()) {
                    maxLeString = words[i];
                }
            }
            res.add(maxLeString);
        }
        return res;
    }
}
