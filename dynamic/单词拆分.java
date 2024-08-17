package dynamic;

import java.util.ArrayList;
import java.util.List;

public class 单词拆分 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("cat");
        wordBreak("catsandog", list);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                //如果i背包当前值大于词的大小
                if(i>= wordDict.get(j).length() && res[i - wordDict.get(j).length()] && s.substring(i - wordDict.get(j).length(), i).equals(wordDict.get(j))){
                    res[i] = true;
                }
            }
        }
        return res[s.length()];
    }

}
