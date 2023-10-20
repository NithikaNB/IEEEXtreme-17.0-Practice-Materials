boolean hasCycleDirected(List<List<Integer>> graph, int n) {
    boolean[] visited = new boolean[n];
    boolean[] recStack = new boolean[n];

    for (int i = 0; i < n; i++) {
        if (isCyclicUtil(graph, i, visited, recStack)) {
            return true;
        }
    }
    return false;
}

boolean isCyclicUtil(List<List<Integer>> graph, int v, boolean[] visited, boolean[] recStack) {
    if (!visited[v]) {
        visited[v] = true;
        recStack[v] = true;

        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor] && isCyclicUtil(graph, neighbor, visited, recStack)) {
                return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }
    }
    recStack[v] = false;
    return false;
}
