package leecode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class leecode_1935_可以输入的最大单词数 {
    public int canBeTypedWords(String text, String brokenLetters) {
        // 1. 将损坏的字母存入Set（使用Stream简化初始化）
        Set<Character> brokenSet = brokenLetters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(HashSet::new));

        // 2. 分割单词并统计有效单词
        int count = 0;
        for (String word : text.split(" ")) {
            // 检查单词是否包含任何损坏的字母
            boolean isValid = true;
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    isValid = false;
                    break; // 一旦发现损坏字母，立即退出检查
                }
            }
            if (isValid) {
                count++;
            }
        }
        return count;
    }
}
