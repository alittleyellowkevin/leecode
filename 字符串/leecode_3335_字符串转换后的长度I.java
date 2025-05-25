package 字符串;

public class leecode_3335_字符串转换后的长度I {
    public static void main(String[] args) {
        lengthAfterTransformations("abcyy", 2);
    }

    public static final int INF = 1000000007;

    public static int lengthAfterTransformations(String s, int t) {
        long[] countChar = new long[26];
        long res = 0; // 使用long避免溢出

        for (int i = 0; i < s.length(); i++) {
            countChar[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t; i++) {
            // 将z 移到 a 和 b
            long z = countChar[25];
            // 从右到左移动数组
            for (int j = 25; j > 0; j--) {
                countChar[j] = countChar[j - 1];
            }
            countChar[0] = z;
            countChar[1] = (countChar[1] + z) % INF;
        }

        for (int i = 0; i < 26; i++) {
            res = (res + countChar[i]) % INF;
        }
        return (int) res;
    }
}
