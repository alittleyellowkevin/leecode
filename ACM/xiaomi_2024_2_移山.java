package ACM;

import java.util.*;
public class xiaomi_2024_2_移山 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int moutainNumber = in.nextInt();
        int magicTimes = in.nextInt();
        int[] moutains = new int[moutainNumber];
        for(int i=0; i<moutainNumber; i++){
            moutains[i] = in.nextInt();
        }
        for(int i=0; i<magicTimes; i++){
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            int height = in.nextInt();
            for(; l<=r; l++){
                moutains[l] -= height;
                if(moutains[l] <= 0){
                    System.out.print(i+1);
                    return;
                }
            }
        }

    }
}
