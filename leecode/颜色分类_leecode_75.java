package leecode;

public class 颜色分类_leecode_75 {
//    给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
//    使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//    我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//    必须在不使用库内置的 sort 函数的情况下解决这个问题。
    public static void main(String[] args) {

    }



    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
    public void sortColors2(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                swap(nums, p0, i);
                if(p0<p1){ //p0<p1说明此时被换走的是 1 所以需要加在p1后面
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i]==1) {
                swap(nums, p1, i);
                p1++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
