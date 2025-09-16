package ACM;

import java.util.Scanner;

public class meituan_2024_2_小美的区间删除 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int arraylength = in.nextInt();
        int zeroNumber = in.nextInt();

        //初始化
        int totolTwo = 0;
        int totolFive = 0;
        int[][] array = new int[arraylength][2];
        for(int i=0; i<arraylength; i++){
            int number = in.nextInt();
            while(number%2 == 0){
                number /= 2;
                array[i][0]++;
                totolTwo++;
            }
            while(number%5 == 0){
                number /= 5;
                array[i][1]++;
                totolFive++;
            }
        }

        // 遍历从左边界l == -1 开始，表示右边界r前面的元素都删除掉，当 r >= length 之后，表示左边界l 的右边都去除
        int l = -1;
        int r = 0;
        long result = 0;
        while(l < arraylength){
            while(r < arraylength && Math.min(totolTwo - array[r][0], totolFive - array[r][1]) >= zeroNumber){
                totolTwo -= array[r][0];
                totolFive -= array[r][1];
                r++;
            }
            if(Math.min(totolTwo, totolFive) >= zeroNumber){
                result += ((r - l - 1) < 0 ? 0 :(r - l - 1));
            }
            l++;
            if(l < arraylength){
                totolTwo += array[l][0];
                totolFive += array[l][1];
            }
        }
        System.out.print(result);
    }
}
