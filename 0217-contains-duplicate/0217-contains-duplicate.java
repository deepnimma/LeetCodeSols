class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> co = new HashSet<>();

        for (int i : nums) {
            if (co.contains(i)) return true;
            else co.add(i);
        } // for

        return false;
    } // containsDuplicate
} // Solution