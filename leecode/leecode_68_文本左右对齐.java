package leecode;

import java.util.ArrayList;
import java.util.List;

public class leecode_68_文本左右对齐 {
    public static void main(String[] args) {
        fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < words.length; i++) {
            if(length + words[i].length() > maxWidth){
                ToString(list, result, sb, maxWidth);
                length = words[i].length() + 1;
                list.clear();
                list.add(words[i]);
            }else {
                length += (words[i].length()+1);
                list.add(words[i]);
            }
        }
        if(list.isEmpty()){
            return result;
        }else {
            length -= 1;
            length = maxWidth-length;
            for (int i = 0; i < list.size(); i++) {
                if(i == list.size()-1){
                    sb.append(list.get(i));
                }else {
                    sb.append(list.get(i));
                    sb.append(" ");
                }
            }
            sb.append(blank(length));
            result.add(sb.toString());
        }
        return result;
    }
    public static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }
    private static void ToString(List<String> list, List<String> result, StringBuffer sb, int maxWidth) {
        int numberLength = 0;
        int stringCount = list.size();
        if(list.size()==1){
            sb.append(list.get(0));
            sb.append(blank(maxWidth - list.get(0).length()));
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            numberLength += list.get(i).length();
        }
        int TatalBlankNumber = maxWidth - numberLength;
        int leftBlack = TatalBlankNumber % (stringCount-1);
        int BlankNumber = TatalBlankNumber / (stringCount-1);

        String Blank = blank(BlankNumber);
        for (int i = 0; i < list.size()-1; i++) {
            if(i<leftBlack){
                sb.append(list.get(i));
                sb.append(Blank);
                sb.append(" ");
            }else {
                sb.append(list.get(i));
                sb.append(Blank);
            }
        }
        sb.append(list.get(list.size()-1));
        result.add(sb.toString());
        sb.delete(0, sb.length());
    }

}
