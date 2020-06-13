class HappyNumberSolution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        
        while (n != 1) {
            int current = n, sum = 0;
            while (current != 0) {
                int last = current % 10;
                sum += last * last;
                current = current /10;
            }
            if (visited.contains(sum)) {
                return false;
            }
            visited.add(sum);
            n = sum;
        }
        
        return true;
    }
}