package hotcode100;

import java.util.*;
import java.util.stream.Collectors;

public class leecode_49_字母异位词分组 {
    /**
     * 排序
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortString = String.valueOf(charArray);
            if(map.containsKey(sortString)){
                List<String> valueList = map.get(sortString);
                valueList.add(s);
            }else {
                List<String> valueList = new ArrayList<>();
                valueList.add(s);
                map.put(sortString,valueList);
            }
        }
        return map.values().stream().collect(Collectors.toList());
    }
}