class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            freq.putIfAbsent(n, 0);
            freq.put(n, freq.get(n) + 1);
        } // for

        int[][] freqDist = new int[freq.keySet().size()][2];
        int i = 0;

        for (int key : freq.keySet()) {
            freqDist[i++] = new int[]{key, freq.get(key)};
        } // for

        Arrays.sort(freqDist, (a, b) -> Integer.compare(-1 * a[1], -1 * b[1]));

        int[] ans = new int[k];

        for (int j = 0; j < k; j++) {
            ans[j] = freqDist[j][0];
        } // for

        return ans;
    } // topKFrequent
} // Solution