class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) num_set.add(num);

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num - 1)) {
                int currNum = num;
                int currStreak = 1;

                while (num_set.contains(currNum + 1)) {
                    currNum += 1;
                    currStreak += 1;
                } // while

                longestStreak = Math.max(longestStreak, currStreak);
            } // if
        } // for

        return longestStreak;
    } // longestConsecutive
} // Solution