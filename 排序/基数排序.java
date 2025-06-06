package 排序;

public class 基数排序 {
    public static void main(String[] args) {
        int[] arr = {1, 11, 23, 58, 3, 5, 21};
//        int[] arr = utils.utils.generateRandomArray(100, 100);
        redixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void redixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        radixSort(arr, 0, arr.length-1, maxbits(arr));
    }
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max !=0){
            res++;
            max /= 10;
        }
        return res;
    }

    public static int getDigit(int number, int d){
        for (int i = 1; i < d; i++) {
            number = number/10;
        }
        return number%10;
    }
    public static void radixSort(int[] arr, int L, int R, int digit){
        final int radix = 10;
        int i=0, j=0;
        //有多少数准备多少辅助空间
        int[] bucket = new int[R - L + 1];
        for (int d=1; d<=digit; d++){//有多少位就进出几次
            //10个空间
             int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i <radix ; i++) {
                count[i] = count[i] + count[i-1];
            }
            for(i = R; i >= L; i--){
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i=L, j=0; i<=R; i++,j++){
                arr[i] = bucket[j];
            }
        }
    }
}
