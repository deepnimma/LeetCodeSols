class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];

        for (int[] dir : prerequisites) {
            graph[dir[0]][dir[1]] = 1;
        } // for

        return sort(graph);
    } // canFinish

    public boolean sort(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) inDegree[j]++;
            } // for
        } // for

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) q.add(i);
        } // for

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            res[idx++] = u;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1) {
                    inDegree[v]--;

                    if (inDegree[v] == 0) q.add(v);
                } // if
            } // for
        } // while

        return (idx == n);
    } // sort
} // Solution