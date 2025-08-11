package 字符串;

public class leecode_3330_找到初始输入字符串Ⅰ {
    public int possibleStringCount(String word) {
        int count = 0;
        for(int i=1; i<word.length(); i++){
            char pre = word.charAt(i-1);
            char mid = word.charAt(i);
            if(mid == pre){
                count++;
            }
        }
        return count+1;
    }
}
