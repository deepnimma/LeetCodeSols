class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String cs = new String(c);

            if (!map.containsKey(cs)) {
                map.put(cs, new ArrayList<>());
            } // if

            map.get(cs).add(s);
        } // for

        List<List<String>> ans = new ArrayList<>();

        for (String key : map.keySet()) {
            ans.add(map.get(key));
        } // for

        return ans;
    } // groupAnagrams
} // Solution