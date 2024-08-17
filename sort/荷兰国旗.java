package sort;

public class 荷兰国旗 {
    public static void main(String[] args) {
        int[] arr = {2, 16, 10, 25, 5, 40, 10, 23, 1, 4, 3,10, 15, 20};
        sort_standard(arr, 10);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
//    method2 ：标准答案
    public static void sort_standard(int[] arr, int number){
        int p1 = 0;
        int count1=-1;
        int p2 = arr.length-1;
        int count2=arr.length;
        while(p1 <= p2){
            if(arr[p1] < number){
                count1++;
                int mid = arr[p1];
                arr[p1] = arr[count1];
                arr[count1] = mid;
                p1++;
                continue;
            }
            if(arr[p1] == number){
                p1++;
                continue;
            }
            if(arr[p2] > number){
                count2--;
                int mid = arr[p2];
                arr[p2] = arr[count2];
                arr[count2] = mid;
                p2--;
                continue;
            }
            if(arr[p2] == number){
                p2--;
                continue;
            }
            int mid;
            mid = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = mid;
        }
    }


//    method1 : 三指针
    public static void sort(int[] arr, int number) {
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i <arr.length; i++) {
            if(arr[i] < number){
                count1++;
            }
            if(arr[i] == number){
                count2++;
            }
            if(arr[i] > number){
                count3++;
            }
        }
        int p1=0;
        int p2=count1;
        int p3=count2+count1;
        while (p1<count1 || p3<arr.length) {
            if(arr[p2] == number){
                p2++;
                continue;
            }
            if (arr[p1] < number && p1<count1) {
                p1++;
                continue;
            }
            if (arr[p1] == number && p1<count1) {
                int mid;
                mid = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = mid;
                p2++;
                continue;
            }
            if (arr[p3] > number && p3<arr.length)  {
                p3++;
                continue;
            }
            if (arr[p3] == number && p3<arr.length) {
                int mid;
                mid = arr[p3];
                arr[p3] = arr[p2];
                arr[p2] = mid;
                p2++;
                continue;
            }
            if(p1<count1 && p3<arr.length) {
                int mid;
                mid = arr[p1];
                arr[p1] = arr[p3];
                arr[p3] = mid;
                p1++;
                p3++;
            }
        }
    }
}
