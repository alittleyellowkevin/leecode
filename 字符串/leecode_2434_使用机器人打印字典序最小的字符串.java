package 字符串;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class leecode_2434_使用机器人打印字典序最小的字符串 {
    static Stack<Character> deque = new Stack<>();
    static StringBuilder result = new StringBuilder();

    static int[] countChars = new int[26];

    public static void main(String[] args) {
        robotWithString("vzhofnpo");
    }
    public static String robotWithString(String s) {
        //1. 计算每个字母的数量
        for(int i=0; i<s.length(); i++){
            countChars[s.charAt(i) - 'a']++;
        }

        //3. 遍历字符串
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            countChars[c - 'a']--;
            deque.add(c);
            while (!deque.isEmpty() && isPrint(deque.peek())){
                c = deque.pop();
                result.append(c);
            }
        }

        //4.返回结果
        while (!deque.isEmpty()){
            result.append(deque.pop());
        }
        return result.toString();
    }

    public static boolean isPrint(char c){
        int cPosition = c - 'a';
        int j = cPosition-1;
        while(j>=0){
            if(countChars[j]>0){
                return false;
            }
            j--;
        }
        return true;
    }
}
