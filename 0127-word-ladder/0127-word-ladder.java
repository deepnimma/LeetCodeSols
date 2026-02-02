class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> data = new HashMap<>();
        preprocess(wordList, data);
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.offer(new Pair<>(beginWord, 1));

        while (!q.isEmpty()) {
            Pair<String, Integer> curr = q.poll();
            if (visited.contains(curr.getKey())) continue;
            else visited.add(curr.getKey());
            if (curr.getKey().equals(endWord)) return curr.getValue();
            List<String> wcs = getWildcards(curr.getKey());

            for (String wc : wcs) {
                List<String> valids = data.get(wc);
                if (valids == null) continue;
                for (String v : valids) {
                    q.offer(new Pair<>(v, curr.getValue() + 1));
                } // for
            } // for
        } // while

        return 0;
    } // ladderLength

    private List<String> getWildcards(String word) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            String ab = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
            ans.add(ab);
        } // for
        return ans;
    } // getWildCards

    private Map<String, List<String>> preprocess(List<String> wordList, Map<String, List<String>> data) {
        for (String word : wordList) {
            List<String> wcs = getWildcards(word);
            for (String ab : wcs) {
                if (!data.containsKey(ab)) data.put(ab, new ArrayList<>());
                data.get(ab).add(word);
            } // for
        } // for

        return data;
    } // preprocess
} // Solution