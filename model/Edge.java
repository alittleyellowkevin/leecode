package model;

public class Edge<T, K> {
    T id;
    K weight;

    public Edge(T id, K weight) {
        this.id = id;
        this.weight = weight;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public K getWeight() {
        return weight;
    }

    public void setWeight(K weight) {
        this.weight = weight;
    }
}
