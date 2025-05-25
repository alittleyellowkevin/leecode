package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ109_最小循环节 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.next();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < line.length(); i++) {
            set.add(line.charAt(i));
        }
        System.out.println(set.size());
    }

}
