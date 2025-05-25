package huawei;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class HJ102_字符统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取输入字符串
        String str = in.nextLine();

        // 统计字符出现次数
        Map<Character, Integer> charCount = countCharacters(str);

        // 将统计结果转换为列表并排序
        List<Map.Entry<Character, Integer>> sortedList = sortByCountAndASCII(charCount);

        // 输出结果
        for (Map.Entry<Character, Integer> entry : sortedList) {
            System.out.print(entry.getKey());
        }
    }

    /**
     * 统计字符串中每个字符出现的次数
     * 
     * @param str 输入字符串
     * @return 字符出现次数的映射
     */
    private static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        return charCount;
    }

    /**
     * 将字符统计结果按照出现次数从多到少排序，次数相同时按照ASCII码从小到大排序
     * 
     * @param charCount 字符出现次数的映射
     * @return 排序后的列表
     */
    private static List<Map.Entry<Character, Integer>> sortByCountAndASCII(Map<Character, Integer> charCount) {
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(charCount.entrySet());

        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                // 首先按照出现次数从多到少排序
                int countCompare = o2.getValue().compareTo(o1.getValue());
                if (countCompare != 0) {
                    return countCompare;
                }
                // 次数相同时按照ASCII码从小到大排序
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        return list;
    }
}