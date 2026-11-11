import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        
        backtrack(nums, used, currentPath, result);
        return result;
    }
    
    private void backtrack(int[] nums, boolean[] used, List<Integer> currentPath, List<List<Integer>> result) {
        // Base case: if current path contains all numbers, we've formed a full permutation
        if (currentPath.size() == nums.length) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        
        // Try placing each unused number into the current position
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue; // Skip already chosen numbers
            }
            
            // 1. Make decision
            used[i] = true;
            currentPath.add(nums[i]);
            
            // 2. Explore further
            backtrack(nums, used, currentPath, result);
            
            // 3. Undo decision (Backtrack)
            currentPath.remove(currentPath.size() - 1);
            used[i] = false;
        }
    }
}