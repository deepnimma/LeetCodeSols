class Solution {
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private void dijkstra(int[] signalReceivedAt, int src, int n) {
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        pq.add(new Pair(0, src));

        signalReceivedAt[src] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> topPair = pq.remove();

            int currNode = topPair.getValue();
            int currNodeTime = topPair.getKey();

            if (currNodeTime > signalReceivedAt[currNode]) continue;
            if (!adj.containsKey(currNode)) continue;

            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int time = edge.getKey();
                int neighborNode = edge.getValue();

                if (signalReceivedAt[neighborNode] > currNodeTime + time) {
                    signalReceivedAt[neighborNode] = currNodeTime + time;
                    pq.add(new Pair(signalReceivedAt[neighborNode], neighborNode));
                } // if
            } // for
        } // while
    } // dijkstra

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Pair(travelTime, dest));
        } // for

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        dijkstra(signalReceivedAt, k, n);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, signalReceivedAt[i]);
        } // for

        return ans == Integer.MAX_VALUE ? -1 : ans;
    } // networkDelayTime
} // Solution