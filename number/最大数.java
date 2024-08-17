package number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 最大数 {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        String[] stringArray = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b)-> {
                    int i = 0;
                    while (i<a.length() || i<b.length()){
                        char first = i<a.length()?a.charAt(i):a.charAt(a.length()-1);
                        char second = i<b.length()?b.charAt(i):b.charAt(b.length()-1);
                        if(first>second){
                            return -1;
                        } else if (second>first) {
                            return 1;
                        }
                        i++;
                    }
                    return 0;
                })
                .toArray(String[]::new);
        System.out.println(Arrays.toString(stringArray));
    }
    public String largestNumber(int[] nums) {
        String[] stringArray = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b)-> {
                    int i = 0;
                    while (i<a.length() || i<b.length()){
                        char first = i<a.length()?a.charAt(i):a.charAt(a.length()-1);
                        char second = i<b.length()?b.charAt(i):b.charAt(b.length()-1);
                        if(first>second){
                            return -1;
                        } else if (second>first) {
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
        return sb.toString().startsWith("0")?"0":sb.toString();
    }
}
