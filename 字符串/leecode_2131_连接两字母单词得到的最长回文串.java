package 字符串;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class leecode_2131_连接两字母单词得到的最长回文串 {
    public static void main(String[] args) {
        longestPalindrome(new String[]{"lc", "cl", "gg"});
    }


    public static int longestPalindrome(String[] words) {
        HashSet<String> sameChars = new HashSet<>();
        HashMap<String,Integer> count = new HashMap<>();
        int res = 0;
        for(String word:words) {
            char first = word.charAt(0);
            char second = word.charAt(1);

            //1.当第一个等于第二个时，判断是否存在相同
            if (first == second) {
                //1.1 包含 word 时
                if (sameChars.contains(word)) {
                    res += 4;
                    sameChars.remove(word);
                }
                //1.2 不包含 word 时
                else {
                    sameChars.add(word);
                }
                //当第一个字母不等于第二字母
            } else {
                char[] wordArray = word.toCharArray();
                char temp = wordArray[0];
                wordArray[0] = wordArray[1];
                wordArray[1] = temp;
                String reverseWord = String.valueOf(wordArray);
                //2.1 count 包含 reverseWord
                if (count.containsKey(reverseWord) && count.get(reverseWord) > 0) {
                    res += 4;
                    count.put(reverseWord, count.get(reverseWord) - 1);
                }
                //2.2 count 不包含 reverseWord
                else {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                }
            }
        }
        return sameChars.size()>0? res+2:res;
    }
}
