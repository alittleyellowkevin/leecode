package ACM;

import java.util.Scanner;

public class meituan_2025_1_小美的陡峭值操作 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queryTimes = in.nextInt();
        for(int i=0; i<queryTimes; i++){
            int arrayLength = in.nextInt();
            int[] array = new int[arrayLength];
            int minDown = -1;
            int maxUp = -1;
            long heap = 0;
            for(int j=0; j<arrayLength; j++){
                array[j] = in.nextInt();
                if(j != 0){
                    heap += Math.abs(array[j] - array[j-1]);
                }
                if(j != 0 && minDown == -1 && array[j-1] > array[j]){
                    minDown = j;
                }
                if(j != 0 && j>maxUp && array[j-1] < array[j]){
                    maxUp = j-1;
                }
            }
            if(maxUp == -1 && minDown == -1){
                System.out.println(heap+1);
            }else if(maxUp == -1 || minDown == -1){
                System.out.println(heap-1);
            }else{
                if(minDown > maxUp){
                    System.out.println(heap-1);
                }else{
                    System.out.println(heap-2);
                }
            }

        }
    }
}
