package string;

public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i)-'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i)-'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i] < 0){
                return false;
            }
        }
        return true;
    }
}
