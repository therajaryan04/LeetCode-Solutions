class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0;   // Keeps track of how many odd prefix sums we've encountered
        long evenCount = 1;  // Start with 1 to account for a base prefix sum of 0 (which is even)
        long currentSum = 0;
        long totalOddSubarrays = 0;
        
        int MOD = 1_000_000_007;
        
        for (int num : arr) {
            currentSum += num;
            
            // If the current running sum is even
            if (currentSum % 2 == 0) {
                // To get an odd subarray sum, we need to subtract a previous odd prefix sum
                totalOddSubarrays += oddCount;
                evenCount++;
            } 
            // If the current running sum is odd
            else {
                // To get an odd subarray sum, we need to subtract a previous even prefix sum
                totalOddSubarrays += evenCount;
                oddCount++;
            }
            
            // Keep the total within the bounds required by LeetCode
            totalOddSubarrays %= MOD;
        }
        
        return (int) totalOddSubarrays;
    }
}