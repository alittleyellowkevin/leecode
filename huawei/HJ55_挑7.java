package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ55_挑7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (isRela7(i)) {
                    res.add(i);
                }
            }
            System.out.println(res.size());
        }
    }

    private static boolean isRela7(int n) {
        if (n % 7 == 0) {
            return true;
        }
        while (n != 0) {
            int number = n % 10;
            if (number == 7) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

}