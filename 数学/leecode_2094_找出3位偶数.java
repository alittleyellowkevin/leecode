package 数学;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class leecode_2094_找出3位偶数 {
    public static void main(String[] args) {

    }

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                continue;
            }
            for (int j = 0; j < digits.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if ((digits[i] * 100 + digits[j] * 10 + digits[k]) % 2 == 0) {
                        res.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                    }
                }
            }
        }

        return res.stream().sorted().mapToInt(n -> {
            return n.intValue();
        }).toArray();
    }
}
