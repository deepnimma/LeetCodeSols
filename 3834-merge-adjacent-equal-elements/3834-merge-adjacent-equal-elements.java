class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Stack<Long> s = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            long currNum = nums[i];

            while (!s.isEmpty() && s.peek() == currNum) {
                currNum += s.pop();
            } // if

            s.push((long) currNum);
        } // for

        return new ArrayList<Long>(s);
    } // mergeAdjacent
} // Solution