class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>(nums.length);
        
        for(int i: nums) {
            if(unique.contains(i)) {
                return true;
            }
            unique.add(i);
        }
        
        return false;
    }
}