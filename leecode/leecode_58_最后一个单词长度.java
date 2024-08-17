package leecode;

import java.util.Arrays;

public class leecode_58_最后一个单词长度 {
    public static void main(String[] args) {

    }
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        for (int i = s1.length; i >= 0; i--) {
            if(!s1[i].equals(" ")){
                return s1[i].length();
            }
        }
        return 0;
    }
}
