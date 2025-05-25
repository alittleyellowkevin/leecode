package 排序;

public class 快排 {
    public static void main(String[] args) {
        int[] arr = utils.utils.generateRandomArray(20, 20);
        quicksort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void quicksort(int[] arr){
        if(arr == null || arr.length==1){
            return;
        }else {
            quickSort(arr, 0, arr.length);
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[(left + right) / 2];
            int i = left;
            int j = right;
            while (i <= j) {
                while (arr[i] < pivot) {
                    i++;
                }
                while (arr[j] > pivot) {
                    j--;
                }
                if (i <= j) {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            }
            quickSort(arr, left, j);
            quickSort(arr, i, right);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int mid = arr[i];
        arr[i] = arr[j];
        arr[j] = mid;
    }
}
