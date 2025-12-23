class Solution {
    public int maxArea(int[] height) {
        int largest = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            largest = Math.max(largest, area);

            if (height[i] > height[j]) j--;
            else i++;
        } // while

        return largest;
    } // maxArea
} // Solution