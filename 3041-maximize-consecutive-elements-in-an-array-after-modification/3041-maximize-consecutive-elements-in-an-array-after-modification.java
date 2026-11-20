import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        
        // dp.get(x) = longest consecutive sequence ending with value x
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        
        for (int num : nums) {
            // Option 1: Increment num to (num + 1) and extend a sequence ending at num
            int extendAsNext = dp.getOrDefault(num, 0) + 1;
            dp.put(num + 1, extendAsNext);
            
            // Option 2: Keep num as-is and extend a sequence ending at (num - 1)
            int extendAsCurrent = dp.getOrDefault(num - 1, 0) + 1;
            dp.put(num, extendAsCurrent);
            
            maxLen = Math.max(maxLen, Math.max(extendAsNext, extendAsCurrent));
        }
        
        return maxLen;
    }
}