package leecode;

import java.util.*;
import java.util.stream.Collectors;

public class leecode_2300_咒语和药水的成功对数 {
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] positions = {1,2,3,4,5};
        long s = 7;
        successfulPairs(spells, positions, s);
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> spellToCount = new HashMap<>();

        // 将 药水 排序
        Arrays.sort(potions);

        // 将 咒语 排序
        List<Integer> sortSpells = new ArrayList<>();
        for(int i=0; i<spells.length; i++){
            sortSpells.add(spells[i]);
        }
        Collections.sort(sortSpells);

        // 从最小的咒语开始
        int j = potions.length-1;
        long potion = potions[j];
        for(int i=0; i < spells.length; i++){
            long spell = sortSpells.get(i);
            // 从最大药水开始
            while(j >=0 && potion * spell >= success){
                j--;
                if(j < 0){
                    break;
                }
                potion = potions[j];
            }
            spellToCount.put((int)spell, potions.length - j - 1);
        }

        for(int i=0; i<spells.length; i++){
            spells[i] = spellToCount.get(spells[i]);
        }

        return spells;
    }
}
