class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        } // for

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neighbor : adjList.get(node)) {
                if (parent.get(node) == neighbor) continue;
                if (parent.containsKey(neighbor)) return false;
                stack.push(neighbor);
                parent.put(neighbor, node);
            } // for
        } // while

        return parent.size() == n;
    } // validTree
} // Solution