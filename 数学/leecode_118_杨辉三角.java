package 数学;

import java.util.ArrayList;
import java.util.List;

public class leecode_118_杨辉三角 {
    public static void main(String[] args) {
        generate(3);
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = generate(rowIndex + 1);
        return list.get(rowIndex);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows == 1) {
            return res;
        } else {
            for (int i = 1; i < numRows; i++) {
                List<Integer> numbers = new ArrayList<>();
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        numbers.add(1);
                    } else {
                        numbers.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                    }
                }
                res.add(numbers);
            }
        }
        return res;
    }
}
