class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int cnt = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = (nums[i] + nums[j]) % d;

                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{i, j});
            } // for
        } // for

        for (int i = 0; i < nums.length; i++) {
            int key = (d - nums[i] % d) % d;
            if (map.containsKey(key)) {
                for (int[] idx : map.get(key)) {
                    cnt += idx[1] < i ? 1 : 0;
                } // for
            } // if
        } // for

        return cnt;
    } // divisibleTripletCount
} // Solution