class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> ints = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] i : intervals) ints.offer(i);
        ints.offer(newInterval);

        int[][] ans = new int[intervals.length + 1][2];
        int i = 0;

        while (!ints.isEmpty()) {
            int[] curr = ints.poll();

            while (!ints.isEmpty() && ints.peek()[0] <= curr[1]) {
                // System.out.println("Merging: " + Arrays.toString(curr) + " and " + Arrays.toString(ints.peek()));
                curr[1] = Math.max(curr[1], ints.poll()[1]);
                // System.out.println("Result: " + Arrays.toString(curr));
            } // while

            ans[i++] = curr;
        } // while

        int[][] realAns = new int[i][2];

        for (int j = 0; j < i; j++) {
            realAns[j] = ans[j];
        } // for

        return realAns;
    } // insert
} // Solution