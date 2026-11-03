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

        for (int i = 0; i < locs1.size(); i++) {
            for (int j = 0; j < locs2.size(); j++) {
                currShort = Math.min(currShort, Math.abs(locs1.get(i) - locs2.get(j)));
            } // for
        } // for

        return currShort;
    } // shortest
} // WordDistance

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */