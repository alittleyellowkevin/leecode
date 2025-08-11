package hotcode100;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class leecode_438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        List<Integer> result = new ArrayList<>();
        p = String.valueOf(chars);
        for(int i=0; i<=s.length()-len; i++){
            char[] subchars = s.substring(i, i+p.length()).toCharArray();
            Arrays.sort(subchars);
            if(p.equals(String.valueOf(subchars))){
                result.add(i);
            }
        }
        return result;
    }

    //滑动窗口
    public List<Integer> findAnagrams1(String s, String p) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];

        List<Integer> result = new ArrayList<>();

        if(s.length()<p.length()){
            return new ArrayList<>();
        }

        // 初始化p的 chars
        for(int i=0; i<p.length(); i++){
            char2[p.charAt(i) - 'a']++;
        }

        // 初始s的 chars
        for(int i=0; i<p.length(); i++){
            char1[s.charAt(i) - 'a']++;
        }

        // 判断此时是否相同
        if(Arrays.compare(char1, char2)==0){
            result.add(0);
        }

        for(int i=p.length(); i<s.length(); i++){
            char1[s.charAt(i-p.length())-'a']--;
            char1[s.charAt(i)-'a']++;
            if(Arrays.compare(char1, char2)==0){
                result.add(i-p.length()+1);
            }
        }
        return  result;
    }
}
