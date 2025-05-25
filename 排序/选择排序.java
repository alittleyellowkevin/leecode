package 排序;


public class 选择排序 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 5};
        selectionSort(arr);
    }
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            int mid = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = mid;

        }
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
