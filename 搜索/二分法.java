package 搜索;

public class 二分法 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6 ,7 ,8};
        System.out.println(find(arr, 8));
    }

    //左开右开
    public static int find(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else {
                if(arr[mid] > target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }
    //左开右闭
    public static int find2(int[] arr, int target){
        int left = 0;
        int right = arr.length; //右闭长度为length
        while (left < right){ // 左右不相等
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else {
                if(arr[mid] > target){
                    left = mid+1;
                }else {
                    right = mid; //右闭，所以不会取right
                }
            }
        }
        return -1;
    }

}
