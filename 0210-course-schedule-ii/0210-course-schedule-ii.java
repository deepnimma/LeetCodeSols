class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[][] graph = new int[n][n];

        for (int[] p : prerequisites) graph[p[1]][p[0]] = 1;

        return sort(graph);
    } // findOrder

    private int[] sort(int[][] graph) {
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
            if (inDegree[i] == 0) q.offer(i);
        } // for

        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            res[idx++] = u;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 1) {
                    inDegree[v]--;

                    if (inDegree[v] == 0) q.offer(v);
                } // if
            } // for
        } // while

        return (idx == n) ? res : new int[0];
    } // sort
} // Solution