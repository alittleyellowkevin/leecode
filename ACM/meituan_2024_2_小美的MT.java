package ACM;

import java.util.Scanner;

public class meituan_2024_2_小美的MT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stringLen = in.nextInt();
        int operateTimes = in.nextInt();

        int count = 0;
        String str = in.next();
        for(int i=0; i<stringLen; i++){
            if(str.charAt(i) == 'M' || str.charAt(i) == 'T'){
                count++;
            }
        }
        System.out.print(count+operateTimes > stringLen ? stringLen:count+operateTimes);
    }
}
