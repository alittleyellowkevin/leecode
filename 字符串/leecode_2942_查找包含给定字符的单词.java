package 字符串;

import java.util.ArrayList;
import java.util.List;

public class leecode_2942_查找包含给定字符的单词 {
    public static void main(String[] args) {

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(word.contains(String.valueOf(x))){
                res.add(i);
            }
        }
        return res;
    }
}
