import java.util.*;

public class dfs_Graph {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<int[]> edgeList = new ArrayList<>();

        System.out.println("Enter edges (u v). Enter -1 -1 to stop:");
        while (true) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            if (u == -1 && v == -1) break;

            edgeList.add(new int[]{u, v});
        }

        // collect all unique nodes
        HashSet<Integer> nodeSet = new HashSet<>();
        for (int[] e : edgeList) {
            nodeSet.add(e[0]);
            nodeSet.add(e[1]);
        }

        // map nodes to 0..n-1
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> reverseMap = new HashMap<>();

        int idx = 0;
        for (int node : nodeSet) {
            map.put(node, idx);
            reverseMap.put(idx, node);
            idx++;
        }

        int n = nodeSet.size();
        int[][] adj = new int[n][n];

        // build adjacency matrix using mapped indexes
        for (int[] e : edgeList) {
            int u = map.get(e[0]);
            int v = map.get(e[1]);
            adj[u][v] = 1;
            adj[v][u] = 1;
        }

        // print adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }

        boolean[] visited = new boolean[n];
        System.out.println("\nDFS starting from smallest node:");

        // start DFS from the smallest original node
        int start = map.get(Collections.min(nodeSet));
        dfs(adj, start, visited, reverseMap);

        System.out.println("\n\nDFS for disconnected components:");
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, reverseMap);
            }
        }
    }

    public static void dfs(int[][] adj, int node, boolean[] visited, HashMap<Integer, Integer> reverseMap) {

        System.out.print(reverseMap.get(node) + " ");
        visited[node] = true;

        for (int i = 0; i < adj.length; i++) {
            if (adj[node][i] == 1 && !visited[i]) {
                dfs(adj, i, visited, reverseMap);
            }
        }
    }
}
