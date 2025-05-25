package huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class HJ80_整型数组合并 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        TreeSet<Integer> set = new TreeSet<>();
        int m = in.nextInt();
        for (int i = 0; i < m; i++) {
            set.add(in.nextInt());
        }
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
