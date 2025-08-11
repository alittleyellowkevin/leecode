package 字符串;

public class leecode_3403_从盒子中找出字典序最大的字符串Ⅰ {
    public static void main(String[] args) {
        answerString("dbca", 2);
        answerString("abacaba", 3);
        answerString("abacaba", 1);
        answerString("abacaba", 4);
        answerString("abacaba", 5);
        answerString("abacaba", 6);
    }
    public static String answerString(String word, int numFriends) {
        //1. 首先确认最大字符串长度
        int maxLength = word.length() - numFriends + 1;

        //2. 初始化
        int maxPosition = 0;

        //3. 除去一个人的情况
        if(numFriends == 1){
            return word;
        }

        //4. 利用只需要比较首字母，若首字母相同则递归下去
        for(int i=1; i<word.length(); i++){
            char maxLetter = word.charAt(maxPosition);
            char currentLetter = word.charAt(i);

            //当两个字符相同时
            int j = maxPosition;
            int k = i;
            int count = 0;
            while(count < maxLength && k+1 < word.length() && maxLetter == currentLetter){
                k++;
                j++;
                count++;
                maxLetter = word.charAt(j);
                currentLetter = word.charAt(k);
            }

            //最大字符串小于最小字符串时
            if(maxLetter - currentLetter < 0){
                maxPosition = i;
            }
        }

        //5. 返回结果
        return  word.substring(maxPosition, Math.min((maxPosition + maxLength), word.length()));
    }
}
