package leecode;

public class leecode_4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total_len = nums1.length + nums2.length;
        if(total_len % 2 == 1){
            return findK(nums1, nums2, total_len/2+1);
        }else {
            return (findK(nums1, nums2, total_len/2) + findK(nums1, nums2, total_len/2+1))/2;
        }
    }

    private double findK(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        while (true){
            if(index1 == len1){
                return nums2[index2 + k -1];
            } else if (index2 == len2) {
                return nums1[index1 + k -1];
            } else if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            int half = k/2;
            int last1 =  Math.min(index1 + half - 1, len1-1);
            int last2 = Math.min(index2 + half -1, len2-1);
            if(nums1[last1] <= nums2[last2]){
                k -= (last1 - index1 + 1);
                index1 = last1 + 1;
            }else {
                k -= (last2 - index2 + 1);
                index2 = last2 + 1;
            }
        }
    }


}
