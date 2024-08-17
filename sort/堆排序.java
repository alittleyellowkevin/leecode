package sort;

import static sort.快排.swap;

public class 堆排序 {
    public static void main(String[] args) {
        int[] arr = utils.utils.generateRandomArray(100, 100);
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    //现在某个数处在index位置，往上继续移动
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index-1)/2);
            index = (index - 1)/2;
        }
    }

    //某个数在index位置，能否往下移动
    private static void heapify(int[] arr,int index, int heapSize){
        int left = index * 2 + 1;//左孩子的下标
        while(left < heapSize){
            //两个孩子中，谁的值更大，把下标给largest
            int largest = (left+1)< heapSize && arr[left+1] > arr[left] ? left+1:left;
            //父和孩子之间，谁的值更大，把下标给largest
            largest = arr[largest] > arr[index] ? largest:index;
            if(largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = left * 2 + 1;
        }
    }
}
