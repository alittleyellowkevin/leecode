package utils;

import java.util.Map;
import java.util.Random;


public class test {
    public static void main(String[] args) {
        int[] arr = utils.generateRandomArray(100, 100);
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
            if(arr[largest] < arr[index]){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = left * 2 + 1;
        }
}

    public static void kuaipai(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        kuaipaisort(arr, 0, arr.length-1);
    }
    public static void kuaipaisort(int[] arr, int L, int R){
        if(R>L){
            swap(arr, L+(int)(Math.random()*(R-L+1)), R);
            int[] p = partition(arr, L, R);
            kuaipaisort(arr, L, p[0]-1);
            kuaipaisort(arr, p[1]+1, R);
        }
    }
    public static int[] partition(int[] arr, int L, int R){
        int less = L-1;
        int more = R;
        while (L<more){
            if(arr[L] < arr[R]){
                swap(arr, ++less, L++);
            } else if (arr[L] > arr[R]) {
                swap(arr, --more, L);
            }else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[]{less+1, more};
    }


    public static void guibing(int[] arr){
        if(arr ==null || arr.length<2){
            return;
        }
        guibingsort(arr,0, arr.length-1);
    }
    public static void guibingsort(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int mid = (L+R)/2;
        guibingsort(arr, L, mid);
        guibingsort(arr, mid+1, R);
        process(arr, L, mid, R);
    }
    public static void process(int[] arr, int L, int M, int R){
        int[] help = new int[R-L+1];
        int p1=L;
        int p2=M+1;
        int i = 0;
        while(p1<=M && p2<=R) {
            help[i++] = arr[p1]<arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for (i = L; i <= R; i++) {
            arr[i] = help[i-L];
        }
    }




    public static void xuanze(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for(int j=i+1; j<arr.length; j++){
                minPos = arr[j] < arr[minPos]? j : minPos;
            }
            swap(arr,minPos, i);
        }
    }
    
    public static void charu(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }
    public static void maopao(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }
    public static void swap(int[] arr, int l, int r){
        int mid = arr[l];
        arr[l] = arr[r];
        arr[r] = mid;
    }
}
