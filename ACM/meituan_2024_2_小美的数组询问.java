package ACM;

import java.util.Scanner;

public class meituan_2024_2_小美的数组询问 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayLength = in.nextInt();
        int queryTimes = in.nextInt();

        long sum = 0;
        int count = 0;
        for(int i=0; i<arrayLength; i++){
            int value =  in.nextInt();
            sum += value;
            count += value == 0 ? 1:0;
        }

        for(int i=0; i<queryTimes; i++){
            long min = in.nextInt();
            long max = in.nextInt();
            System.out.print(sum + min * count);
            System.out.print(" ");
            System.out.print(sum + max * count);
            System.out.println();
        }
    }
}
