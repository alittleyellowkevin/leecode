package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leecode_17_电话号码的字母组合 {
    public static void main(String[] args) {
        letterCombinations("23");
    }
    public static List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        if(digits == ""){
            return result;
        }
        StringBuffer sb = new StringBuffer();
        create(map, sb, result, digits, 0);
        return result;
    }

    private static void create(Map<Character, String> map, StringBuffer sb, List<String> result, String digits, int i) {
        if(sb.length() == digits.length()){
            result.add(sb.toString());
            return;
        }
        for (int j = 0; j < map.get(digits.charAt(i)).length(); j++) {
            sb.append(map.get(digits.charAt(i)).charAt(j));
            create(map, sb, result, digits, 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
