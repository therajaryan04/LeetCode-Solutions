import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];

            // Since candidates is sorted, no later number can fit
            if (val > remaining) {
                break;
            }

            // Choose
            current.add(val);

            // Explore (pass 'i' because the same element can be reused)
            backtrack(candidates, remaining - val, i, current, result);

            // Un-choose (backtrack)
            current.remove(current.size() - 1);
        }
    }
}