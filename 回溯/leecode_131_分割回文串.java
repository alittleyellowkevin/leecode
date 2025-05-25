package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leecode_131_分割回文串 {
    public static void main(String[] args) {
        partition("aab");
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        ArrayList<String> substring = new ArrayList<>();
        back(chars, res, substring, 0, s);
        return res;
    }

    private static void back(char[] chars, List<List<String>> res, ArrayList<String> substring, int i, String s) {
        if (i == chars.length) {
            res.add((List<String>) substring.clone());
        } else {
            for (int j = i; j < chars.length; j++) {
                if (isHuiwen(chars, i, j)) {
                    substring.add(s.substring(i, j + 1));
                    back(chars, res, substring, j + 1, s);
                    substring.remove(substring.size() - 1);
                }
            }
        }
    }

    private static boolean isHuiwen(char[] charArray, int i, int j) {
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
