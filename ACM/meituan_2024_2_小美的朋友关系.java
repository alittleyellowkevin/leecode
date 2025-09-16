package ACM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class meituan_2024_2_小美的朋友关系 {
    static class UnionFind {
        int[] parent, rank;
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return;
            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else { parent[pb] = pa; rank[pa]++; }
        }
        boolean connected(int a, int b) {
            return find(a) == find(b);
        }
    }

    static class Event {
        int type, a, b;
        long key;
        Event(int type, int a, int b, long key) {
            this.type = type;
            this.a = a;
            this.b = b;
            this.key = key;
        }
    }

    private static long edgeKey(int a, int b) {
        if (a > b) { int t = a; a = b; b = t; }
        return ((long)a << 32) | (b & 0xffffffffL);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totolPopulation = Integer.parseInt(st.nextToken());
        int initRelation = Integer.parseInt(st.nextToken());
        int eventNumber = Integer.parseInt(st.nextToken());

        // 收集所有出现的点编号做离散化
        Set<Integer> nodeSet = new HashSet<>();
        int[] initU = new int[initRelation];
        int[] initV = new int[initRelation];
        for (int i = 0; i < initRelation; i++) {
            st = new StringTokenizer(br.readLine());
            initU[i] = Integer.parseInt(st.nextToken());
            initV[i] = Integer.parseInt(st.nextToken());
            nodeSet.add(initU[i]);
            nodeSet.add(initV[i]);
        }

        int[] typeArr = new int[eventNumber];
        int[] uArr = new int[eventNumber];
        int[] vArr = new int[eventNumber];
        for (int i = 0; i < eventNumber; i++) {
            st = new StringTokenizer(br.readLine());
            typeArr[i] = Integer.parseInt(st.nextToken());
            uArr[i] = Integer.parseInt(st.nextToken());
            vArr[i] = Integer.parseInt(st.nextToken());
            nodeSet.add(uArr[i]);
            nodeSet.add(vArr[i]);
        }

        // 离散化映射
        List<Integer> nodes = new ArrayList<>(nodeSet);
        Collections.sort(nodes);
        Map<Integer, Integer> idMap = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            idMap.put(nodes.get(i), i);
        }

        // 初始边集合
        Set<Long> curEdges = new HashSet<>();
        for (int i = 0; i < initRelation; i++) {
            int a = idMap.get(initU[i]);
            int b = idMap.get(initV[i]);
            curEdges.add(edgeKey(a, b));
        }

        // 事件存储
        Event[] events = new Event[eventNumber];
        boolean[] effective = new boolean[eventNumber];
        for (int i = 0; i < eventNumber; i++) {
            int a = idMap.get(uArr[i]);
            int b = idMap.get(vArr[i]);
            long key = edgeKey(a, b);
            events[i] = new Event(typeArr[i], a, b, key);
        }

        // 正向找有效删除
        for (int i = 0; i < eventNumber; i++) {
            if (events[i].type == 1) {
                if (curEdges.contains(events[i].key)) {
                    curEdges.remove(events[i].key);
                    effective[i] = true;
                }
            }
        }

        // 并查集初始化（只对出现的点建）
        UnionFind uf = new UnionFind(nodes.size());
        // 加入最终存在的边
        for (long e : curEdges) {
            int a = (int)(e >> 32);
            int b = (int)(e & 0xffffffffL);
            uf.union(a, b);
        }

        // 逆序处理
        List<String> ans = new ArrayList<>();
        for (int i = eventNumber - 1; i >= 0; i--) {
            Event ev = events[i];
            if (ev.type == 1) {
                if (effective[i]) {
                    uf.union(ev.a, ev.b);
                }
            } else {
                ans.add(uf.connected(ev.a, ev.b) ? "Yes" : "No");
            }
        }

        // 反转输出
        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i)).append("\n");
        }
        System.out.print(sb);
    }
}
