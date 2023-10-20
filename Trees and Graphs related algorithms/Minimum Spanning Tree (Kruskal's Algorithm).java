import java.util.*;

class Graph {
    int V, E;
    List<int[]> edges;
    
    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edges = new ArrayList<>();
    }
    
    public void addEdge(int u, int v, int w) {
        edges.add(new int[] {u, v, w});
    }
    
    public int kruskal() {
        Collections.sort(edges, Comparator.comparingInt(e -> e[2]));
        int[] parent = new int[V];
        Arrays.fill(parent, -1);
        int minCost = 0;
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int setU = find(parent, u);
            int setV = find(parent, v);
            if (setU != setV) {
                minCost += w;
                union(parent, setU, setV);
            }
        }
        return minCost;
    }
    
    private int find(int[] parent, int v) {
        if (parent[v] == -1) return v;
        return find(parent, parent[v]);
    }
    
    private void union(int[] parent, int u, int v) {
        int setU = find(parent, u);
        int setV = find(parent, v);
        if (setU != setV) {
            parent[setU] = setV;
        }
    }
}
