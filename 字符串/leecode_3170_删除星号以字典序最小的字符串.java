package 字符串;

public class leecode_3170_删除星号以字典序最小的字符串 {
    public static void main(String[] args) {

    }
    int[] countChars = new int[26];
    public String clearStars(String s) {
       //1.计数
        for(int i=0; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                countChars[s.charAt(i) - 'a']++;
            }
        }

        //2.倒过来查询
        int countStar = 0;
        StringBuilder result = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            if(c == '*') {
                countStar++;
                continue;
            }
            countChars[c-'a']--;
            if(!isDelte(c, countStar)){
                result.append(c);
            }else {
                countStar--;
            }
        }
        if(countStar>0){
            result = new StringBuilder(result.substring(0, result.length()-countStar));
        }
        return result.reverse().toString();
    }

    private boolean isDelte(char c, int countStar) {
        if(countStar<=0){
            return false;
        }
        for(int i=c-'a'-1; i>=0; i--){
            if(countChars[i]>0){
                return false;
            }
        }
        return true;
    }
}
