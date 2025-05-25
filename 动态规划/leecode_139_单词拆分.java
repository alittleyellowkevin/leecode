package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class leecode_139_单词拆分 {
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

        // 1. res[i] 表示s[0,i]是否可以被拆分
        boolean[] res = new boolean[s.length() + 1];

        // 2. 初始化 res[0] = true;
        res[0] = true;

        // 3. 遍历s，计算res[i]
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                // 如果i背包当前值大于词的大小, 且res[i - wordDict.get(j).length()] 为true, 且s.substring(i -
                // wordDict.get(j).length(), i).equals(wordDict.get(j))
                if (i >= wordDict.get(j).length() && res[i - wordDict.get(j).length()]
                        && s.substring(i - wordDict.get(j).length(), i).equals(wordDict.get(j))) {
                    res[i] = true;
                }
            }
        }
        return res[s.length()];
    }

}
