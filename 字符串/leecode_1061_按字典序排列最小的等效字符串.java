package 字符串;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leecode_1061_按字典序排列最小的等效字符串 {
    int[] parent;

    leecode_1061_按字典序排列最小的等效字符串(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void unite(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        // 总是让字典序更小的作为集合代表字符
        parent[y] = x;
    }
}
