class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> n = new HashSet<>();
        int longest = 0;

        for (int i : nums) n.add(i);
        for (int num : n) {
            if (!n.contains(num - 1)) {
                int curr_streak = 1;
                int curr = num;

                while (n.contains(curr + 1)) {
                    curr_streak += 1;
                    curr += 1;
                } // while

                longest = Math.max(longest, curr_streak);
            } // if
        } // for

        return longest;
    } // longestConsecutive
} // Solution