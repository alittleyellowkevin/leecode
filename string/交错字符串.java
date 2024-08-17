package string;

public class 交错字符串 {
    public static void main(String[] args) {
        isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        //res表示0-i的字符串与0-j的字符串是否能得到s3
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        for (int i = 0; i < res.length; i++) {
            if(s1.substring(0, i).equals(s3.substring(0, i))){
                res[i][0] = true;
            }
        }
        for (int i = 0; i < res[0].length; i++) {
            if(s2.substring(0, i).equals(s3.substring(0, i))){
                res[0][i] = true;
            }
        }
        for (int i = 1; i < res.length; i++) {
            for (int j = 1; j < res[0].length; j++) {
                if(res[i-1][j]== false && res[i][j-1]==false){
                    res[i][j] = false;
                }else {
                    if((res[i-1][j] == true && s1.charAt(i-1) == s3.charAt(i+j-1)) || (res[i][j-1] == true && s2.charAt(j-1) == s3.charAt(i+j-1))){
                        res[i][j] = true;
                    }
                }
            }
        }
        return res[s1.length()][s2.length()];
    }
}