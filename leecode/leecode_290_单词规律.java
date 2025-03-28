package leecode;

import java.util.HashMap;

public class leecode_290_单词规律 {
    public static void main(String[] args) {

    }
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if(pattern.length() != strings.length){
            return false;
        }

        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(strings[i])){
                    return false;
                }
            }else{
                if(map.containsValue(strings[i])){
                    return false;
                }
                map.put(c, strings[i]);
            }
        }
        return true;
    }
}
