public class AdjacencyMatrixGraph {
    public static void main(String[] args) {

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 0}
        };

        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] > max) max = edges[i][0];
            if (edges[i][1] > max) max = edges[i][1];
        }

        int n = max + 1; 

        int[][] adj = new int[n][n];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
