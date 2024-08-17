package leecode;

public class Excel表名称 {
    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int columnNumber) {
        StringBuilder s = new StringBuilder();
        while(columnNumber != 0){
            if(columnNumber == 26){
                s.append('Z');
                break;
            }
            char a = (columnNumber % 26 == 0) ? 'Z' :(char)(((columnNumber % 26)-1)+'A');
            columnNumber = columnNumber / 26;
            s.append(a);
        }
        return s.reverse().toString();
    }
}
