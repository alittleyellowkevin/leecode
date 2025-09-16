package leecode;

public class leecode_1493_删掉一个元素以后全为1的最长子数组 {

    public static void main(String[] args) {

    }
    public int longestSubarray(int[] nums) {
        int result = 0;
        if(nums.length == 1){
            return 0;
        }
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == 1){
                pre[i] = pre[i-1] + nums[i];
            }else {
                pre[i] = 0;
            }
        }
        post[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] == 1){
                post[i] = post[i+1] + nums[i];
            }else {
                post[i] = 0;
            }
        }
        if(post[0] == nums.length){
            return nums.length-1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                result = Math.max(result, Math.max(pre[i], post[i]));
            }else {
                int count = (i!=0?pre[i-1] : 0) + (i!=nums.length-1?post[i+1] : 0);
                result = Math.max(result, count);
            }
        }
        return result;
    }
}
