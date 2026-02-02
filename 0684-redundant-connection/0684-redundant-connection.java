class Solution {
    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0] - 1).add(edge[1] - 1);
            adjList.get(edge[1] - 1).add(edge[0] - 1);
        } // for

        dfs(0, visited, adjList, parent);

        Map<Integer, Integer> cycleNodes = new HashMap<>();
        int node = cycleStart;

        do {
            cycleNodes.put(node, 1);
            node = parent[node];
        } while (node != cycleStart);

        for (int i = edges.length - 1; i >= 0; i--) {
            if (
                cycleNodes.containsKey(edges[i][0] - 1) &&
                cycleNodes.containsKey(edges[i][1] - 1)
            ) return edges[i];
        } // for

        return new int[] {};
    } // findRedundantConnection

    private void dfs(int src, boolean[] visited, List<List<Integer>> adjList, int[] parent) {
        visited[src] = true;

        for (int adj : adjList.get(src)) {
            if (!visited[adj]) {
                parent[adj] = src;
                dfs(adj, visited, adjList, parent);
            } else if (adj != parent[src] && cycleStart == -1) {
                cycleStart = adj;
                parent[adj] = src;
            } // if-else if
        } // for
    } // dfs
} // Solution