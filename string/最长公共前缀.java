package string;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int min_length = strs[0].length();
        String res = "";
        for(int i=1; i<strs.length; i++)
        {
            min_length = min_length > strs[i].length() ? strs[i].length() : min_length;
        }
        for(int i=0; i<min_length; i++){
            char tag = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(strs[j].charAt(i) != tag)
                {
                    return res;
                }
            }
            res += tag;
        }
        return res;
    }
}
