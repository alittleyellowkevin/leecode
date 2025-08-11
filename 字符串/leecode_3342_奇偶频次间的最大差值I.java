package 字符串;

public class leecode_3342_奇偶频次间的最大差值I {
    public static void main(String[] args) {

    }
    public int maxDifference(String s) {
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        int[] counts = new int[26];

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cNumber = c - 'a';
            counts[cNumber]++;
        }

        for(int count : counts){
            if(count % 2 == 1 && count > maxOdd){
                maxOdd = count;
            } else if (count % 2 == 0 && count < minEven) {
                minEven = count;
            }
        }

        return maxOdd - minEven;
    }
}
