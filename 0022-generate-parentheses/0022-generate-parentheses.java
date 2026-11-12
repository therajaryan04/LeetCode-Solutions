import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, n);
        return result;
    }
    
    private void dfs(List<String> result, String current, int open, int close, int n) {
        // Base case: if the string reaches length 2 * n, add it to our results
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }
        
        // Add opening bracket if we haven't reached the limit 'n'
        if (open < n) {
            dfs(result, current + "(", open + 1, close, n);
        }
        
        // Add closing bracket if it won't exceed the number of open brackets
        if (close < open) {
            dfs(result, current + ")", open, close + 1, n);
        }
    }
}