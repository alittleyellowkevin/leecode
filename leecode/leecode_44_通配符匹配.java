package leecode;

public class leecode_44_通配符匹配 {
    public static void main(String[] args) {
        isMatch("adceb", "*a*b");
    }
    public static boolean isMatch(String s, String p) {
        boolean[][] matrix = new boolean[s.length() + 1][p.length() + 1];

        //初始化
        matrix[0][0] = true;
        for (int i = 1; i < s.length()+1; i++) {
            matrix[i][0] = false;
        }
        for (int i = 1; i < p.length()+1; i++) {
            if(p.charAt(i-1) == '*'){
                matrix[0][i] = matrix[0][i-1];
            }else {
                matrix[0][i] = false;
            }
        }
        for (int i = 1; i < s.length()+1; i++) {
            for (int j = 1; j < p.length()+1; j++) {

                if(p.charAt(j-1) == '*'){
                    for (int k = i; k>=0; k--){
                        matrix[i][j] = matrix[i][j] || matrix[k][j-1];
                    }
                } else if (p.charAt(j-1) == '?') {
                    matrix[i][j] = matrix[i-1][j-1];
                }else {
                    if(s.charAt(i-1) == p.charAt(j-1)){
                        matrix[i][j] = matrix[i-1][j-1];
                    }else {
                        matrix[i][j] = false;
                    }
                }
            }
        }
        return matrix[s.length()][p.length()];
    }
}

