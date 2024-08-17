package hash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 有效的数独_leecode_36 {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> hang = new ArrayList<>();
        List<Set<Character>> lie = new ArrayList<>();
        List<Set<Character>> fang = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            hang.add(new HashSet<>());
            lie.add(new HashSet<>());
            fang.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current == '.') {
                    continue;
                }

                if (hang.get(i).contains(current) || lie.get(j).contains(current) || fang.get(i / 3 * 3 + j / 3).contains(current)) {
                    return false;
                } else {
                    hang.get(i).add(current);
                    lie.get(j).add(current);
                    fang.get(i / 3 * 3 + j / 3).add(current);
                }
            }
        }

        return true;
    }
}
