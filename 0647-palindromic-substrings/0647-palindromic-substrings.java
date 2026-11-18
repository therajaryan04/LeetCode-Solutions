class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Count odd-length palindromes (single character center)
            count += expandAroundCenter(s, i, i);
            
            // Count even-length palindromes (two character center)
            count += expandAroundCenter(s, i, i + 1);
        }
        
        return count;
    }
    
    // Helper method to expand outward and count valid palindromes from a center
    private int expandAroundCenter(String s, int left, int right) {
        int palindromes = 0;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindromes++;
            left--;
            right++;
        }
        
        return palindromes;
    }
}