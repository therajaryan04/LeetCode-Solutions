import java.util.HashSet;
import java.util.Set;

class Solution {
    private int totalSolutions = 0;

    public int totalNQueens(int n) {
        totalSolutions = 0; // Reset counter for each call
        
        // Sets to track unsafe columns and diagonals (same logic as N-Queens I)
        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiags = new HashSet<>(); // (row + col)
        Set<Integer> negativeDiags = new HashSet<>(); // (row - col)
        
        backtrack(0, n, cols, positiveDiags, negativeDiags);
        return totalSolutions;
    }
    
    private void backtrack(int row, int n, 
                           Set<Integer> cols, 
                           Set<Integer> positiveDiags, 
                           Set<Integer> negativeDiags) {
        // Base case: We successfully placed queens in all rows, so we found 1 valid arrangement
        if (row == n) {
            totalSolutions++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int posDiag = row + col;
            int negDiag = row - col;
            
            // If the column or diagonals are already occupied, skip this spot
            if (cols.contains(col) || positiveDiags.contains(posDiag) || negativeDiags.contains(negDiag)) {
                continue;
            }
            
            // Choose: Mark column and diagonals as occupied
            cols.add(col);
            positiveDiags.add(posDiag);
            negativeDiags.add(negDiag);
            
            // Explore: Move to the next row
            backtrack(row + 1, n, cols, positiveDiags, negativeDiags);
            
            // Un-choose (Backtrack): Clean up state sets for the next iteration
            cols.remove(col);
            positiveDiags.remove(posDiag);
            negativeDiags.remove(negDiag);
        }
    }
}