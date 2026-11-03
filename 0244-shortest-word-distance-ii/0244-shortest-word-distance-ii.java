class WordDistance {
    Map<String, List<Integer>> locs = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            locs.putIfAbsent(wordsDict[i], new ArrayList<>());
            locs.get(wordsDict[i]).add(i);
        } // for
    } // wordDistance
    
    public int shortest(String word1, String word2) {
        List<Integer> locs1 = locs.get(word1);
        List<Integer> locs2 = locs.get(word2);
        int currShort = Integer.MAX_VALUE;
        int i = 0, j = 0;

        while (i < locs1.size() && j < locs2.size()) {
            int locs1Index = locs1.get(i);
            int locs2Index = locs2.get(j);
            currShort = Math.min(currShort, Math.abs(locs1Index - locs2Index));

            if (locs1Index < locs2Index) i++;
            else j++;
        } // while

        return currShort;
    } // shortest
} // WordDistance

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */