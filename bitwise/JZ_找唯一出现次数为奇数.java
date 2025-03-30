package bitwise;

public class JZ_找唯一出现次数为奇数 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 2, 2, 4, 5, 5};
        find(arr);
    }
    public static void find(int[] arr){
        int result = arr[0];
        for (int i =1 ; i<arr.length; i++){
            result = result ^ arr[i];
        }
        System.out.println(result);
    }
}
