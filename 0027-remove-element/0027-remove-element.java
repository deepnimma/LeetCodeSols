class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, lastElem = nums.length - 1;
        int occur = 0;

        while (i <= lastElem) {
            if (nums[i] == val) {
                nums[i] = nums[lastElem--];
                occur++;
            } else i++;
        } // for

        return nums.length - occur;
    } // removeElement
} // Solution