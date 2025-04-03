package huawei;

import java.util.*;

public class HJ27_查找兄弟单词 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            List<String> strArray = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strArray.add(in.next());
            }

            String mainString = in.next();
            int k = in.nextInt();

            Iterator<String> iterator = strArray.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                if (!isBrother(s, mainString)) {
                    iterator.remove();
                }
            }
            strArray.sort((a, b) -> a.compareTo(b));

            System.out.println(strArray.size());
            if (strArray.size() >= k) {
                System.out.println(strArray.get(k - 1));
            }

        }
    }

    public static boolean isBrother(String a, String b) {
        if (a.equals(b) || a.length() != b.length()) {
            return false;
        }
        HashMap<Character, Integer> countmap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            countmap.put(a.charAt(i), countmap.getOrDefault(a.charAt(i), 0) + 1);
        }

        for (int i = 0; i < b.length(); i++) {
            if (countmap.containsKey(b.charAt(i)) && countmap.get(b.charAt(i)) > 0) {
                countmap.put(b.charAt(i), countmap.get(b.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
