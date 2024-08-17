package partition;

public class 获取最大值 {

//    master公式
//    T(N) = a*T(N/b) + O(N^d)
//    (1) log(b,a) > d  -> 复杂度O(N^log(b,a))
//    (2) log(b,a) = d  -> 复杂度O(N^d*logN)
//    (3) log(b,a) < d  -> 复杂度O(N^d)
    public static void main(String[] args) {
        int[] arr = utils.utils.generateRandomArray(10, 10);
        for(int i = 0; i<arr.length;  i++){
            System.out.println(arr[i]);
        }
        System.out.println(findMax(arr, 0, arr.length-1));
    }

    public static int findMax(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); //中点
        int leftMax = findMax(arr, L, mid);
        int rightMax = findMax(arr, mid+1, R);
        return Math.max(leftMax, rightMax);
    }
}
