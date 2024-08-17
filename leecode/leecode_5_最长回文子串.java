package leecode;

public class leecode_5_最长回文子串 {
    //方法一 中心扩展法
    public String longestPalindrome(String s) {
        int[] max = new int[]{0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] len1 = findlen(s, i, i);
            int[] len2 = findlen(s, i, i+1);
            max =  max[1]-max[0] < len1[1]-len1[0] ?len1:max;
            max = max[1]-max[0] < len2[1]-len2[0] ?len2:max;
        }
        return s.substring(max[0], max[1]+1);
    }

    private int[] findlen(String s, int l, int r) {
        while (l>=0 && r<=s.length()-1 && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return new int[]{l+1, r-1};
    }
}
