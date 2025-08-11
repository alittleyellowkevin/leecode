package hotcode100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class leecode_3_无重复子串 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int start = -1;
        Set<Character> characterSet = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!characterSet.contains(c)){
                characterSet.add(c);
            }else {
                while (start < i){
                    start++;
                    characterSet.remove(s.charAt(start));
                    if(s.charAt(start) == c){
                        break;
                    }
                }
                characterSet.add(c);
            }
            result = Math.max(i - start, result);
        }
        return result==0? s.length():result;
    }
}
