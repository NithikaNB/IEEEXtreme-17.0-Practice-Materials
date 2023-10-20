import java.util.*;

class Graph {
    int V;
    List<int[]>[] adj;
    
    public Graph(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int u, int v, int w) {
        adj[u].add(new int[] {v, w});
        adj[v].add(new int[] {u, w}); // For undirected graph
    }
    
    public int dijkstra(int src, int dest) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> dist[i]));
        pq.add(src);
        
        while (!pq.isEmpty()) {
            int u = pq.poll();
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(v);
                }
            }
        }
        return dist[dest];
    }
}
