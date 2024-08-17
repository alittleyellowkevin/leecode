package sort;

public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = utils.utils.generateRandomArray(100, 100);
        maopao(arr);
    }
//    public static void maopao(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j<arr.length-1; j++) {
//                if(arr[j] > arr[j+1]){
//                    int mid = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = mid;
//                }
//            }
//        }
//        for(int i=0; i<arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
    int[] arr = {2, 1, 4, 9, 7};
    public static void maopao(int[] arr){
        //循环次数
        for(int i = 0; i < arr.length-1; i++){
            for (int j = 0; j <  arr.length-1; j++) {
                if(arr[j] > arr[j+1]){
                    int mid = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = mid;
                }
            }
        }
    }
}
