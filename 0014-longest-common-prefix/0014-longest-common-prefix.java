class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Loop through each character of the first string
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            
            // Compare this character against all other strings in the array
            for (int j = 1; j < strs.length; j++) {
                // If index 'i' reaches the end of another string or characters don't match,
                // the common prefix ends here.
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If the loop finishes, the entire first string is the common prefix
        return strs[0];
    }
}