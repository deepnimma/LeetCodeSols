class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        
        int n = nums.length;
        int[] res = new int[n - k + 1];

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((o1, o2) -> (o2 - o1));

        for (int i = 0; i < n; i++) {
            int start = i - k;
            if (start >= 0) maxPQ.remove(nums[start]);
            maxPQ.offer(nums[i]);

            if (maxPQ.size() == k) {
                res[i - k + 1] = maxPQ.peek();
            } // if
        } // for

        return res;
    } // maxSlidingWindow
} // Solution