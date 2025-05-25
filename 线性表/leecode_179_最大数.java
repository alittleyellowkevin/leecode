package 线性表;

import java.util.Arrays;

public class leecode_179_最大数 {
    public static void main(String[] args) {
    }

    public String largestNumber(int[] nums) {
        String[] stringArray = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> {
                    int i = 0;
                    while (i < a.length() || i < b.length()) {
                        char first = i < a.length() ? a.charAt(i) : a.charAt(a.length() - 1);
                        char second = i < b.length() ? b.charAt(i) : b.charAt(b.length() - 1);
                        if (first > second) {
                            return -1;
                        } else if (second > first) {
                            return 1;
                        }
                        i++;
                    }
                    return 0;
                })
                .toArray(String[]::new);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringArray.length; i++) {
            sb.append(stringArray[i]);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
