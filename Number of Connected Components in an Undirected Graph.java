int countComponents(int n, int[][] edges) {
    UnionFind uf = new UnionFind(n);
    for (int[] edge : edges) {
        int u = edge[0];
        int v = edge[1];
        uf.union(u, v);
    }

    Set<Integer> components = new HashSet<>();
    for (int i = 0; i < n; i++) {
        components.add(uf.find(i));
    }
    return components.size();
}
