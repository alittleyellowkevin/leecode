package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ74_参数解析 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().trim().split(" ");

        List<String> res = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith("\"")) {
                res.add(strs[i]);
            } else {
                String now = "";
                while (!strs[i].endsWith("\"")) {
                    now += strs[i] + " ";
                    i++;
                }
                now += strs[i];
                res.add(now.substring(1, now.length() - 1));
            }
        }
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
