package ACM;
import java.util.*;

public class jingdong_2024_1_字符串排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Character, Integer> rank = new HashMap<>();
        char[] chars = in.nextLine().toCharArray();
        for(int i = 0; i<chars.length; i++){
            rank.put(chars[i], i+1);
        }
        int stringSize = in.nextInt();
        in.nextLine();
        String[] stringArray = new String[stringSize];
        for(int i=0; i<stringSize; i++){
            stringArray[i] = in.nextLine();
        }
        Arrays.sort(stringArray, (a, b) -> {
            char[] array1 = a.toCharArray();
            char[] array2 = b.toCharArray();
            for(int i=0; i<Math.max(array1.length,array2.length); i++){
                int rank1 = i<array1.length? rank.get(array1[i]) : -1;
                int rank2 = i<array2.length? rank.get(array2[i]) : -1;
                if(rank1 != rank2){
                    return rank1 - rank2;
                }
            }
            return 0;
        });
        for(String str : stringArray){
            System.out.println(str);
        }
    }
}
