package leecode;

import java.util.*;

import model.Edge;
import model.ListGraph;

public class leecode_399_除法求值 {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        equations.add(equation1);
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation2);
        double[] values = new double[]{2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> query1 = new ArrayList<>();
        query1.add("a");
        query1.add("c");
        queries.add(query1);
        List<String> query2 = new ArrayList<>();
        query2.add("b");
        query2.add("a");
        queries.add(query2);
        List<String> query3 = new ArrayList<>();
        query3.add("a");
        query3.add("e");
        queries.add(query3);
        List<String> query4 = new ArrayList<>();
        query4.add("a");
        query4.add("a");
        queries.add(query4);
        leecode_399_除法求值 re = new leecode_399_除法求值();
        double[] res = re.calcEquation(equations, values, queries);
        for (double re1 : res) {
            System.out.println(re1);
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ListGraph<String, Double> graph = new ListGraph<>();
        //构建图
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String node1 = equation.get(0);
            String node2 = equation.get(1);
            double value = values[i];
            graph.addEdge(node1, node2, value);
            graph.addEdge(node2, node1, 1/value);
        }

        //处理queries
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String node1 = query.get(0);
            String node2 = query.get(1);
            if (!graph.hasVertex(node1) || !graph.hasVertex(node2)) {
                res[i] = -1.0;
            }else {
                HashSet<String> visited = new HashSet<>();
                visited.add(node1);
                res[i] = node1.equals(node2) ? 1 : dfs(graph, node1, node2, visited);
            }
        }
        return res;
    }

    private double dfs(ListGraph<String, Double> graph, String node1, String node2, HashSet<String> visited) {
        List<Edge<String, Double>> edges = graph.getVertex(node1);
        double res = 0;
        for (Edge<String, Double> edge : edges) {
            if(visited.contains(edge.getId())){
                continue;
            }
            if(edge.getId().equals(node2)){
                return edge.getWeight();
            }else {
                visited.add(edge.getId());
                double result = dfs(graph, edge.getId(), node2, visited);
                if(result > 0){
                    return result * edge.getWeight();
                }
                visited.remove(edge.getId());
            }
        }
        return  -1;
    }

}
