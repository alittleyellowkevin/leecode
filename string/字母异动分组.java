package string;

import java.util.*;

public class 字母异动分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<ArrayList<Integer>, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                list.add(0);
            }
            for (int j = 0; j < strs[i].length(); j++) {
                //得到此单词的计数表
                list.set(strs[i].charAt(j) - 'a', list.get(strs[i].charAt(j) - 'a')+1);
            }
            //将此单词的计数表与map中的比较如果有相同的则将其加入到该键中，如果没有相同的则创造新键并加入其中
            if(map.size()>0){
                Set<ArrayList<Integer>> keys = map.keySet();
                boolean flag = true;
                for(ArrayList<Integer> key : keys){
                    for (int j = 0; j < 26; j++) {
                        if(key.get(j) != list.get(j)){
                            flag = false;
                        }
                    }
                    if(flag){
                        //如果还是true，则将其加入此key中
                        map.get(key).add(strs[i]);
                        break;
                    }
                }
                if(flag == false){
                    ArrayList<String> s = new ArrayList<>();
                    s.add(strs[i]);
                    map.put(list, s);
                }
            }else {
                ArrayList<String> s = new ArrayList<>();
                s.add(strs[i]);
                map.put(list, s);
            }

        }
        Collection<ArrayList<String>> values = map.values();

        // 遍历value集合并输出
        for (ArrayList<String> value : values) {
            res.add(value);
        }
        return res;
    }

}
