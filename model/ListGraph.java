package model;

import java.util.*;

public class ListGraph<T, K> {
    HashMap<T, LinkedList<Edge<T, K>>> vertexs; // key:vertex_id,value：边的集合

    public ListGraph() {
        vertexs = new HashMap<>();
    }

    public void addEdge(T id1, T id2, K weight) {
        if (!vertexs.containsKey(id1)) {
            LinkedList<Edge<T, K>> edges = new LinkedList<>();
            edges.add(new Edge<>(id2, weight));
            vertexs.put(id1, edges);
        } else {
            vertexs.get(id1).add(new Edge<>(id2, weight));
        }
    }

    public void removeEdge(T id1, T id2) {
        if (vertexs.containsKey(id1)) {
            LinkedList<Edge<T, K>> edges = vertexs.get(id1);
            for (Edge<T, K> edge : edges) {
                if (edge.id.equals(id2)) {
                    edges.remove(edge);
                    break;
                }
            }
        }
    }

    public boolean hasVertex(T id) {
        return vertexs.containsKey(id);
    }

    public LinkedList<Edge<T, K>> getVertex(T id) {
        return vertexs.get(id);
    }

    public K getWeight(T id1, T id2) {
        LinkedList<Edge<T, K>> edges = vertexs.get(id1);
        for (Edge<T, K> edge : edges) {
            if (edge.id.equals(id2)) {
                return (K) edge.weight;
            }
        }
        return null;
    }
}
