package 贪心;

import java.util.Arrays;

public class 分发饼干 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int res = 0;
        while (i<g.length && j<s.length){
            if(s[j] >= g[i]){
                res++;
                i++;
                j++;
            }else {
                j++;
            }
        }
        return res;
    }
}
