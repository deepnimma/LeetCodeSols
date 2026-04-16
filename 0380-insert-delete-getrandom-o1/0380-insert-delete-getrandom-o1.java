class RandomizedSet {
    Map<Integer, Integer> indexMap;
    List<Integer> randSet;
    Random randGen;

    public RandomizedSet() {
        indexMap = new HashMap<>();
        randSet = new ArrayList<>();
        randGen = new Random();
    } // RandomizedSet
    
    public boolean insert(int val) {
        if (indexMap.containsKey(val)) return false;
        indexMap.put(val, randSet.size());
        randSet.add(val);
        return true;
    } // insert
    
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) return false;

        // Get Index
        int valIndex = indexMap.get(val);

        // Get Array Last Element
        int lastElem = randSet.get(randSet.size() - 1);

        // Perform Swap
        randSet.set(valIndex, lastElem);

        // Update indexMap
        indexMap.put(lastElem, valIndex);

        // Remove removing val
        indexMap.remove(val);

        // Remove Last Element of ArrayList
        randSet.remove(randSet.size() - 1);

        return true;
    } // remove
    
    public int getRandom() {
        return randSet.get(randGen.nextInt(randSet.size()));
    } // getRandom
} // RandomizedSet

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */