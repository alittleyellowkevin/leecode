package 数学;

public class leecode_3304_找出第K个字符Ⅰ {
    public char kthCharacter(int k) {
        int ans = 0;
        int t;
        while(k != 1){
            t = 31 - Integer.numberOfLeadingZeros(k);
            if((1 << t) == k){
                t--;
            }
            k -= (1 << t);
            ans++;
        }
        return (char)('a' + ans);
    }
}
