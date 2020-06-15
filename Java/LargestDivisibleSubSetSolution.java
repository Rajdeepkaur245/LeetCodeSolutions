class LargestDivisibleSubSetSolution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        
        int dp[] = new int[nums.length];
        int index[] = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(index, -1);
        int maxSize = 0, maxIndex = -1;
        
        for(int i=0; i<nums.length;i++) {
            for(int j=i-1; j>=0;j--) {
                if(nums[i] %nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }
            }
            if (maxSize<dp[i]) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        
        int i = maxIndex;
        while(i>=0) {
            result.add(nums[i]);
            i=index[i];
        }
        
        return result;
    }
}