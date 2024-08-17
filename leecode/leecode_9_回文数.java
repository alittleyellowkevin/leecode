package leecode;

public class leecode_9_回文数 {
    public static void main(String[] args) {
    }
    //方法一:转换为字符串
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String str = Integer.toString(x);
        int l = 0;
        int r = str.length()-1;
        while (l<r){
            if(str.charAt(l) != str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    //方法二:反转一般半数字
    public boolean isPalindrome2(int x) {
        if(x<0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int reverseNum = 0;
        while (reverseNum<x){
            reverseNum = reverseNum * 10 + x%10;
            x/=10;
        }
        return reverseNum == x || reverseNum/10 == x;
    }
}
