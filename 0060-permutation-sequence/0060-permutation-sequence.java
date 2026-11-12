import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        
        // 1. Initialize the list of numbers [1, 2, ..., n] and compute (n-1)!
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            if (i < n) {
                fact *= i; // fact will hold (n-1)! at the end of the loop
            }
        }
        
        // Convert k to 0-based index
        k--;
        
        StringBuilder sb = new StringBuilder();
        
        // 2. Build the permutation digit by digit
        for (int i = n; i > 0; i--) {
            int index = k / fact; // Find which group/number to pick
            sb.append(numbers.get(index));
            numbers.remove(index); // Remove chosen number so it isn't reused
            
            if (i > 1) {
                k %= fact;       // Update k for the next position
                fact /= (i - 1);  // Scale down the factorial for the next digit
            }
        }
        
        return sb.toString();
    }
}