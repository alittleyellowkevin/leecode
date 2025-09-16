package utils;

public class utils {
    public static void main(String[] args) {
        double i = 1;
        double j = 3;
        double k = 3;
        System.out.println(i / j * k);
    }
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 随机长度
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
