package huawei;

import java.util.Scanner;

public class HJ99_自守数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number = in.nextLong();
        int count = 0;
        for (long i = 0; i <= number; i++) {
            if (isZiShou(i)) {
                count++;
            }
        }
    }

    private static boolean isZiShou(long number) {
        int count = 0;
        long numbercopy = number;
        while (numbercopy != 0) {
            count++;
            numbercopy /= 10;
        }
        long numberSquare = number * number;
        while (count != 0) {
            long a = numberSquare % 10;
            long b = number % 10;
            if (a != b) {
                return false;
            }
            number /= 10;
            numberSquare /= 10;
            count--;
        }
        return true;
    }

}
