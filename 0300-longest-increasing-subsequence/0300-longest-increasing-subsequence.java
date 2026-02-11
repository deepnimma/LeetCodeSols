class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n > sub.get(sub.size() - 1)) sub.add(n);
            else {
                int j = search(sub, n);
                sub.set(j, n);
            } // if-else
        } // for

        return sub.size();
    } // lengthOfLIS

    private int search(List<Integer> sub, int n) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = left + (right - left) / 2;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (sub.get(mid) == n) return mid;
            if (sub.get(mid) < n) left = mid + 1;
            else right = mid;
        } // while

        return left;
    } // search
} // Solution