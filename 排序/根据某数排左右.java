package 排序;

public class 根据某数排左右 {
    public static void main(String[] args) {
        int[] arr = utils.utils.generateRandomArray(20, 20);
        sort(arr, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void sort(int[] arr, int number){
        int p1 = 0;
        int p2 = arr.length-1;
        while(p1 < p2){
            if(arr[p1] <= number){
                p1++;
                continue;
            }
            if(arr[p2] > number){
                p2--;
                continue;
            }
            int mid;
            mid = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = mid;
            p1++;
            p2--;
        }
    }
}
