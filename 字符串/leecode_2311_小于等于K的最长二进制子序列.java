package 字符串;

public class leecode_2311_小于等于K的最长二进制子序列 {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int sum = 0;
        int start = s.length()-1;
        while (start>=0){
            char c = s.charAt(start);
            sum += ((c-'0') * Math.pow(2, s.length()-1-start));
            if(sum > k){
                break;
            }
            count++;
            start--;
        }
        while(start>=0){
            char c= s.charAt(start);
            if(c == '0'){
                count++;
            }
            start--;
        }
        return count;
    }
}
