package 数学;

public class leecode_367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = (int) Math.pow(Integer.MAX_VALUE, 0.5);
        if (num > Math.pow(right, 2) || num < left) {
            return false;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((int) Math.pow(mid, 2) == num) {
                return true;
            } else {
                if ((int) Math.pow(mid, 2) > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
