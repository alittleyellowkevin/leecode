package leecode;

public class leecode_28_找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        int[] next = new int[needle.length()];
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && nee[i] != nee[j]) {
                j = nee[j - 1];
            }
            if (nee[i] == nee[j]) {
                j++;
            }
            next[i] = j;
        }
        return -1;
    }
}
