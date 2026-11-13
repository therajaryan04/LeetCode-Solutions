class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) {
            return 0;
        }
        
        int[] cuts = new int[n];
        // Initialize cuts: maximum cuts for a string of length i is i
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }
        
        // Expand around each possible center
        for (int center = 0; center < n; center++) {
            
            // 1. Odd-length palindromes (single character center)
            expandAndCover(s, center, center, cuts);
            
            // 2. Even-length palindromes (between two characters center)
            expandAndCover(s, center, center + 1, cuts);
        }
        
        return cuts[n - 1];
    }
    
    private void expandAndCover(String s, int l, int r, int[] cuts) {
        // Expand outward as long as it's a valid palindrome
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // If the palindrome starts at index 0, zero cuts are needed for this prefix
            int currentCut = (l == 0) ? 0 : cuts[l - 1] + 1;
            cuts[r] = Math.min(cuts[r], currentCut);
            l--;
            r++;
        }
    }
}