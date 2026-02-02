class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        } // for

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        } // for

        int cnt = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                System.out.println(i);
                dfs(adjList, visited, i);
                cnt++;
            }
        } // for

        return cnt;
    } // countComponents

    private void dfs(List<List<Integer>> adjList, Set<Integer> visited, int i) {
        visited.add(i);

        for (int n : adjList.get(i)) {
            if (!visited.contains(n)) dfs(adjList, visited, n);
        } // for
    } // dfs
} // Solution