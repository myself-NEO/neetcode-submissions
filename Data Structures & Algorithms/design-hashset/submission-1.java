class MyHashSet {

    List<Integer> set;

    public MyHashSet() {
        set = new ArrayList<>();
    }
    
    public void add(int key) {
        for(int x : set) {
            if(x == key) return;
        }
        set.add(key);
        return;
    }
    
    public void remove(int key) {
        for(int x : set) {
            if(x == key) {
                set.remove(Integer.valueOf(key));
                return;
            }
        }
        return;
    }
    
    public boolean contains(int key) {
        for(int x : set) {
            if(x == key) return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */