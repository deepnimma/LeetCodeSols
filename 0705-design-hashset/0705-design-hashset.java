class MyHashSet {
    Map<Integer, Boolean> hashSet;

    public MyHashSet() {
        hashSet = new HashMap<>(); 
    } // MyHashSet
    
    public void add(int key) {
        hashSet.put(key, true); 
    } // add
    
    public void remove(int key) {
        hashSet.remove(key); 
    } // remove
    
    public boolean contains(int key) {
        return hashSet.containsKey(key);
    } // contains
} // MyHashSet

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */