package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leecode_22_括号生成 {
    public static void main(String[] args) {
        generateParenthesis(3);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        generate(n, res, sb, n, n);
        return res;
    }

    private static void generate(int n, List<String> res, StringBuffer sb, int l, int r) {
        if (l == 0 && r == 0) {
            res.add(sb.toString());
        } else if (l == 0) {
            sb.append(')');
            generate(n, res, sb, l, r - 1);
            sb.deleteCharAt(2 * n - l - r);
        } else {
            if (l == r) {
                sb.append('(');
                generate(n, res, sb, l - 1, r);
                sb.deleteCharAt(2 * n - l - r);
            } else {
                sb.append('(');
                generate(n, res, sb, l - 1, r);
                sb.deleteCharAt(2 * n - l - r);
                sb.append(')');
                generate(n, res, sb, l, r - 1);
                sb.deleteCharAt(2 * n - l - r);
            }
        }
    }
}
