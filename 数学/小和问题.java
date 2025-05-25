package 数学;

//在一个数组中，每个数左边比当前数小的累加起来，叫做这个数组的小和
public class 小和问题 {
    public static void main(String[] args) {
        int[] arr = utils.utils.generateRandomArray(10, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int result = mergesort(arr);
        System.out.println("result:" + result);
    }

    public static int mergesort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return process(arr, L, mid) + process(arr, mid + 1, R) + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int count = 0;
        while (p1 <= M && p2 <= R) {
            if (arr[p1] <= arr[p2]) {
                count += arr[p1] * (R - p2 + 1);
                help[i++] = arr[p1++];
            } else {
                help[i++] = arr[p2++];
            }
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return count;
    }
}
