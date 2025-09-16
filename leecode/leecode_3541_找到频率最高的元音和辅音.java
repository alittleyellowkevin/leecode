package leecode;

import java.util.HashSet;
import java.util.Set;

public class leecode_3541_找到频率最高的元音和辅音 {
    public int maxFreqSum(String s) {
        Set<Integer> oSet = new HashSet<>();
        oSet.add('a'-'a');
        oSet.add('e'-'a');
        oSet.add('i'-'a');
        oSet.add('o'-'a');
        oSet.add('u'-'a');

        int[] charCount = new int[26];
        for(int i=0; i<s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }
        int maxO = 0;
        int maxNotO = 0;
        for(int i=0; i<26; i++){
            if(oSet.contains(i)){
                maxO = Math.max(maxO, charCount[i]);
            }else {
                maxNotO = Math.max(maxNotO, charCount[i]);
            }
        }
        return maxO + maxNotO;
    }
}
