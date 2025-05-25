package 排序;

public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        insertionSort(arr);
    }
    public static void insertionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            // 0~ i 做到有序
            for(int j=i-1; j>=0 && arr[j]>arr[j+1]; j--){
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[i] ^ arr[j];
                arr[i] = arr[i] ^ arr[j];
            }
        }
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
