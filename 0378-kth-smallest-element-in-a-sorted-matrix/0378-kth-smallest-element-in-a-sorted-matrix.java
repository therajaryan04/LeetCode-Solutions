class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        
        // Binary search on the value range from min to max
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // Count how many elements are less than or equal to mid
            int count = countLessEqual(matrix, mid, n);
            
            if (count < k) {
                low = mid + 1; // K-th smallest is larger than mid
            } else {
                high = mid;    // mid could be the answer, try to find a smaller valid value
            }
        }
        
        return low;
    }
    
    // Helper method to count elements <= mid in O(N) time using staircase search
    private int countLessEqual(int[][] matrix, int mid, int n) {
        int count = 0;
        int row = n - 1; // Start at the bottom-left corner
        int col = 0;
        
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                // If the element is <= mid, then all elements above it in this column are also <= mid
                count += (row + 1);
                col++; // Move right to check the next column
            } else {
                row--; // Move up because the current element is too large
            }
        }
        
        return count;
    }
}