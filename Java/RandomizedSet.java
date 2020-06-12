class RandomizedSet {
    Map<Integer, Integer> valueMap;
    List<Integer> valueList;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueMap = new HashMap<>();
        valueList = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueMap.containsKey(val)) {
            return false;
        }
        valueMap.put(val, valueList.size());
        valueList.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueMap.containsKey(val)) {
            return false;
        }
        int index = valueMap.get(val);
        int lastIndex = valueList.size() - 1;
        int lastElement = valueList.get(lastIndex);
        
        Collections.swap(valueList, index, lastIndex);
        valueList.remove(lastIndex);
        
        valueMap.put(lastElement, index);
        valueMap.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = new Random().nextInt(valueList.size());
        return valueList.get(randomIndex);        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */