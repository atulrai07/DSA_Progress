import java.util.*;

public class TopologicalSortDFS {

    static class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v); // u → v (directed edge)
        }

        void topologicalSort() {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    dfs(i, visited, stack);
                }
            }

            System.out.println("Topological Sort (using DFS):");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }

        void dfs(int v, boolean[] visited, Stack<Integer> stack) {
            visited[v] = true;

            for (int neighbor : adj.get(v)) {
                if (!visited[neighbor]) {
                    dfs(neighbor, visited, stack);
                }
            }

            stack.push(v); // push after visiting neighbors
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        // Sample DAG
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        g.topologicalSort();
    }
}
