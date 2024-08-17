package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_22_括号生成 {
    public static void main(String[] args) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        generate(n, n, sb, res, n);
        return res;
    }

    private static void generate(int left, int right, StringBuffer sb, List<String> res, int n) {
        if(sb.length() == 2*n){
            res.add(sb.toString());
        }else {
            if(left>0){
                sb.append("(");
                generate(left-1, right, sb, res, n);
                sb.deleteCharAt(sb.length()-1);
                if(left < right){
                    sb.append(")");
                    generate(left, right-1, sb, res, n);
                    sb.deleteCharAt(sb.length()-1);
                }
            }else {
                sb.append(")");
                generate(left, right-1, sb, res, n);
                sb.deleteCharAt(sb.length()-1);
            }

        }
    }
}
