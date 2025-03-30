package array;

public class 牛客_调整数组顺序使得奇数位于偶数前面 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public int[] reOrderArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                for (int j = i; j >= 1; j--) {
                    if (array[j - 1] % 2 == 0) {
                        swap(array, j, j - 1);
                    }
                }
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int mid = array[i];
        array[i] = array[j];
        array[j] = mid;
    }
}
