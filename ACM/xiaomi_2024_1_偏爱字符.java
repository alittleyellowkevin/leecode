package ACM;
import java.util.*;

public class xiaomi_2024_1_偏爱字符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrayLength = in.nextInt();
        int favorLength = in.nextInt();
        in.nextLine();

        Set<Character> favorSet = new HashSet<>();
        char[] favor = in.nextLine().toCharArray();
        for(int i=0; i<favor.length; i++){
            if(favor[i]>='A' && favor[i]<='Z'){
                favorSet.add(favor[i]);
            }
        }
        char[] arrayChar = in.nextLine().toCharArray();
        int Lmax = -1;
        int[] arrayLmax = new int[arrayChar.length];
        int Rmax = -1;
        int[] arrayRmax = new int[arrayChar.length];
        for(int i=0; i<arrayLength; i++){
            if(favorSet.contains(arrayChar[i])){
                Lmax = i;
            }
            arrayLmax[i] = Lmax;
        }
        for(int i=arrayLength-1; i>=0; i--){
            if(favorSet.contains(arrayChar[i])){
                Rmax = i;
            }
            arrayRmax[i] = Rmax;
        }
        for(int i=0; i<arrayLength; i++){
            if(!favorSet.contains(arrayChar[i])){
                if(arrayLmax[i] == -1 && arrayRmax[i] == -1){
                    continue;
                }
                if(arrayLmax[i] == -1 && arrayRmax[i] != -1){
                    arrayChar[i] = arrayChar[arrayRmax[i]];
                    continue;
                }
                if(arrayLmax[i] != -1 && arrayRmax[i] == -1){
                    arrayChar[i] = arrayChar[arrayLmax[i]];
                    continue;
                }
                int lDiff = i - arrayLmax[i];
                int rDiff = arrayRmax[i] - i;
                arrayChar[i] = lDiff <= rDiff ? arrayChar[arrayLmax[i]] : arrayChar[arrayRmax[i]];
            }
        }
        System.out.println(String.valueOf(arrayChar));
    }
}
