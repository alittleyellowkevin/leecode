package entity;

//邻接矩阵
public class MatrixGraph<T> {
    T[][] matrix;
    int vertexNum;

    public MatrixGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        matrix = (T[][]) new Object[vertexNum][vertexNum];
    }

    public void addEdge(int i, int j, T weight) {
        matrix[i][j] = weight;
    }

    public void removeEdge(int i, int j) {
        matrix[i][j] = null;
    }

    public boolean hasEdge(int i, int j) {
        return matrix[i][j] != null;
    }

    public T getWeight(int i, int j) {
        return matrix[i][j];
    }

    public int getVertexNum() {
        return vertexNum;
    }


}
