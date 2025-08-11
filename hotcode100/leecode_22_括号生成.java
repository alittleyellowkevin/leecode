package hotcode100;

import java.util.ArrayList;
import java.util.List;

public class leecode_22_括号生成 {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuffer sb = new StringBuffer();
        backsort(sb, 0, 0, n);
        return result;
    }

    private void backsort(StringBuffer sb, int l, int r, int n) {
        if(l == n && r == n){
            result.add(sb.toString());
        }
        if (l < n) {
            sb.append("(");
            backsort(sb, l+1, r, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (l > r && r < n) {
            sb.append(")");
            backsort(sb, l, r+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
