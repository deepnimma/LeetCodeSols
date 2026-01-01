class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : stones) pq.offer(i);

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();

            if (x != y) {
                pq.offer(y - x);
            } // if
        } // while

        return pq.size() == 0 ? 0 : pq.poll();
    } // lastStoneWeight
} // Solution