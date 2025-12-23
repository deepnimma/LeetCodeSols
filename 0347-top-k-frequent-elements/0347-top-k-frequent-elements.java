class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        } // for

        List<Pair> pairSet = new ArrayList<>();

        for (int f : freqMap.keySet()) {
            pairSet.add(new Pair(f, freqMap.get(f)));
        } // for

        pairSet.sort(Comparator.comparingInt(Pair::getB).reversed());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pairSet.get(i).a;
        } // for

        return ans;
    } // topKFrequest

    class Pair {
        int a;
        int b;

        public int getB() {
            return b;
        } // getB

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        } // Pair

        public void print() {
            System.out.println("a: " + this.a + ". b: " + this.b);
        } // print
    } // Pair
} // Solution