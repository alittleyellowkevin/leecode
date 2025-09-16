package ACM;

import java.util.Scanner;

public class meituan_2025_1_行走 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dataGroup = in.nextInt();
        for(int i=0; i<dataGroup; i++){
            int arrayLength = in.nextInt();
            long absSum = 0;
            for(int j=0; j<arrayLength; j++){
                absSum += Math.abs(in.nextLong());
            }
            long initX = in.nextLong();
            long initY = in.nextLong();
            long targetX = in.nextLong();
            long targetY = in.nextLong();
            long diff  = Math.abs(initX - targetX) + Math.abs(initY - targetY);
            if((diff % 2) == (absSum % 2) && absSum >= diff){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}
