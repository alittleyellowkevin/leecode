package utils;

public class utils {
    // Math.random() -> [0， 1）内所有小数，等概率返回一个
    // Math.random() * N -> [0, N)所有小数，等概率返回一个
    // （int)(Math.random() * N) -> [0, N-1] 所有的整数等概率返回一个

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())]; // 随机长度
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }
}
