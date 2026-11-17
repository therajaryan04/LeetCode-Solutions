import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with empty spots '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Sets to track unsafe columns and diagonals
        Set<Integer> cols = new HashSet<>();
        Set<Integer> positiveDiags = new HashSet<>(); // (row + col)
        Set<Integer> negativeDiags = new HashSet<>(); // (row - col)
        
        backtrack(0, n, board, cols, positiveDiags, negativeDiags, result);
        return result;
    }
    
    private void backtrack(int row, int n, char[][] board, 
                           Set<Integer> cols, 
                           Set<Integer> positiveDiags, 
                           Set<Integer> negativeDiags, 
                           List<List<String>> result) {
        // Base case: If we've successfully placed queens in all rows, save the board configuration
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int posDiag = row + col;
            int negDiag = row - col;
            
            // If the column or diagonals are already occupied, skip this spot
            if (cols.contains(col) || positiveDiags.contains(posDiag) || negativeDiags.contains(negDiag)) {
                continue;
            }
            
            // Choose: Place the queen
            board[row][col] = 'Q';
            cols.add(col);
            positiveDiags.add(posDiag);
            negativeDiags.add(negDiag);
            
            // Explore: Move to the next row
            backtrack(row + 1, n, board, cols, positiveDiags, negativeDiags, result);
            
            // Un-choose (Backtrack): Remove the queen and clean up state sets
            board[row][col] = '.';
            cols.remove(col);
            positiveDiags.remove(posDiag);
            negativeDiags.remove(negDiag);
        }
    }
    
    // Helper method to convert the 2D char array into the required List<String> format
    private List<String> constructBoard(char[][] board) {
        List<String> builtBoard = new ArrayList<>();
        for (char[] row : board) {
            builtBoard.add(new String(row));
        }
        return builtBoard;
    }
}