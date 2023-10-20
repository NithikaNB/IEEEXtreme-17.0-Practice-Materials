boolean hasCycleUndirected(int[][] edges, int n) {
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        if (uf.find(u) == uf.find(v)) {
            return true;
        }
        uf.union(u, v);
    }
    return false;
}
