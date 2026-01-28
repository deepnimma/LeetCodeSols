class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        } // for

        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        } // for

        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, adj, visited, stack)) return false;
        } // for

        return true;
    } // canFinish

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] stack) {
        if (stack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        stack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (dfs(neighbor, adj, visited, stack)) return true;
        } // for

        stack[node] = false;
        return false;
    } // dfs
} // Solution