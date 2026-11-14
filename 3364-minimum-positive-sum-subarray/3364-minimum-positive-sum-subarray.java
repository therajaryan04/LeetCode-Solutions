class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        
        // Enumerate every possible starting point
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            
            // Enumerate every possible ending point
            for (int j = i; j < n; j++) {
                currentSum += nums.get(j);
                int length = j - i + 1;
                
                // Check if the length is within [l, r] and the sum is strictly positive
                if (length >= l && length <= r && currentSum > 0) {
                    minSum = Math.min(minSum, currentSum);
                }
            }
        }
        
        // If minSum was never updated, no valid subarray exists
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}