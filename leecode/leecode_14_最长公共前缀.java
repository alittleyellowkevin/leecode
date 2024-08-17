package leecode;

public class leecode_14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int minlength = Integer.MAX_VALUE;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            minlength = Math.min(minlength, strs[i].length());
        }
        for (int i = 0; i < minlength; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                flag = flag && (strs[j].charAt(i) == strs[0].charAt(i));
            }
            if(!flag){
                return sb.toString();
            }else {
                sb.append(strs[0].charAt(i));
            }
        }
        return sb.toString();
    }
}
