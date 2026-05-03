class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int cnt = 0;

        for (int start = 0; cnt < nums.length; start++) {
            int curr = start;
            int prev = nums[start];

            do {
                int next = (curr + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                curr = next;
                cnt++;
            } while (start != curr);
        } // for
    } // rotate
} // Solution