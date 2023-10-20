class Edge implements Comparable<Edge> {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

int minimumSpanningTree(List<Edge> edges, int n) {
    UnionFind uf = new UnionFind(n);
    int minCost = 0;
    Collections.sort(edges);

    for (Edge edge : edges) {
        int u = edge.u;
        int v = edge.v;
        if (uf.find(u) != uf.find(v)) {
            minCost += edge.weight;
            uf.union(u, v);
        }
    }
    return minCost;
}
