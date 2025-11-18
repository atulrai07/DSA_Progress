import java.util.Scanner;

public class AdjacencyMatrixGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        int[][] edges = new int[e][2];

        System.out.println("Enter edges (u v):");

        int max = 0;

        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            edges[i][0] = u;
            edges[i][1] = v;

            if (u > max) max = u;
            if (v > max) max = v;
        }

        int n = max + 1; // number of nodes

        int[][] adj = new int[n][n]; 

        // Fill the matrix
        for (int i = 0; i < e; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj[u][v] = 1;
            adj[v][u] = 1; 
        }

        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
}
