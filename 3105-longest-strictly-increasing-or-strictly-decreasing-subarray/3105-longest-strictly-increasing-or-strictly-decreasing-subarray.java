class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int maxLen = 1;
        int inc = 1; // Length of current strictly increasing subarray
        int dec = 1; // Length of current strictly decreasing subarray
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1; // Reset decreasing sequence
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1; // Reset increasing sequence
            } else {
                // Equal values break both strictly increasing and decreasing trends
                inc = 1;
                dec = 1;
            }
            
            // Track the maximum length encountered so far
            maxLen = Math.max(maxLen, Math.max(inc, dec));
        }
        
        return maxLen;
    }
}