package 字符串;

public class 有效的字母异位词 {
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
