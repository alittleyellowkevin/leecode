package boring;

public class 找出两个出现次数为奇数 {
    public static void main(String[] args) {
        int[] arr = {3, 3, 1, 1, 2, 2, 4, 5, 5, 6};
        findtwo(arr);

    }
    public static void findtwo(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        int rightOne = eor & (~eor + 1); //提取出最右的1

        int onlyOne = 0;
        for(int cur : arr){
            if((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}
