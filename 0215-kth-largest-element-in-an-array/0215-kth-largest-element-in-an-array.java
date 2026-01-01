class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k || pq.peek() < nums[i]) {
                pq.offer(nums[i]);

                if (pq.size() > k) pq.poll();
            } // if
        } // for

        return pq.peek();
    } // findKthLargest
} // Solution