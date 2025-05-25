package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ101_排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        int order = in.nextInt();
        if (order == 0) {
            Arrays.sort(array, (a, b) -> a - b);
        } else {
            Arrays.sort(array, (a, b) -> b - a);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
