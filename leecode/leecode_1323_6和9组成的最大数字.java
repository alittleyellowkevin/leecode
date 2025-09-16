package leecode;

public class leecode_1323_6和9组成的最大数字 {
    public int maximum69Number (int num) {
        char[] numbers = String.valueOf(num).toCharArray();
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == '6'){
                numbers[i] = '9';
                break;
            }
        }
        return Integer.valueOf(String.valueOf(numbers));
    }
}
