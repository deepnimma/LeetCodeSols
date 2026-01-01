class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(distance(a), distance(b))
        ); // pq

        for (int[] c : points) {
            Integer[] i = new Integer[]{c[0], c[1]};
            pq.offer(i);
        } // for

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            Integer[] a = pq.poll();
            int[] n = new int[]{a[0].intValue(), a[1].intValue()};
            ans[i] = n;
        } // for

        return ans;
    } // kClosest

    private double distance(Integer[] pt) {
        double xComp = Math.pow(pt[0], 2);
        double yComp = Math.pow(pt[1], 2);

        return Math.sqrt(Math.abs(xComp + yComp));
    } // distance
} // Solution