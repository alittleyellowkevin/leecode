import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ19_简答错误记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<String, Integer> linkMap = new LinkedHashMap();

        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] strs = str.split(" ");

            // 处理文件路径
            String filePath = strs[0];
            String[] files = filePath.split("\\\\");
            String fileName = files[files.length - 1];
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }

            // 行号
            String lineNum = strs[1];

            String key = fileName + " " + lineNum;

            if (linkMap.containsKey(key)) {
                linkMap.put(key, linkMap.get(key) + 1);
            } else {
                linkMap.put(key, 1);
            }
        }
        int skipCount = linkMap.size() > 8 ? linkMap.size() - 8 : 0;
        for (String key : linkMap.keySet()) {
            if (skipCount > 0) {
                skipCount--;
                continue;
            }
            System.out.println(key + " " + linkMap.get(key));
        }
    }
}