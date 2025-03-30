package dynamic;

public class leecode_474_一和零 {
    public static void main(String[] args) {
        String[] strs = {"01", "0001", "111001", "1", "0"};
        System.out.println(strs[1]);
        findMaxForm(strs, 5, 3);
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] res = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int[] zo = zerOne(strs[i]);
            for (int j = m; j >= 0; j--) {
                for (int k=n; k >=0; k--) {
                    //取第一个字符串的零和一的个数
                    if(j-zo[0] >=0 && k-zo[1]>=0){
                        res[j][k] = Math.max(res[j-zo[0]][k-zo[1]]+1, res[j][k]);
                    }
                }
            }
        }
        return res[m][n];
    }
    public static int[] zerOne(String s){
        int zero = 0;
        int one = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0')zero++;
            if(s.charAt(i) == '1')one++;
        }
        return new int[]{zero, one};
    }
}
