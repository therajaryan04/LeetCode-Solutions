import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // HashMap to store (prefixSum -> frequency of its occurrence)
        Map<Integer, Integer> prefixSumCounts = new HashMap<>();
        
        // Base case: A prefix sum of 0 has occurred 1 time.
        // This handles subarrays that start directly from index 0 and sum up to k.
        prefixSumCounts.put(0, 1);
        
        for (int num : nums) {
            currentSum += num;
            
            // Check if there is a previous prefix sum that equals (currentSum - k)
            int target = currentSum - k;
            if (prefixSumCounts.containsKey(target)) {
                count += prefixSumCounts.get(target);
            }
            
            // Add the current prefix sum to the map (or increment its frequency)
            prefixSumCounts.put(currentSum, prefixSumCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}