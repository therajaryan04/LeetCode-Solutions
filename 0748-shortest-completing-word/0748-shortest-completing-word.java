class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licenseCounts = new int[26];
        
        // 1. Build the frequency count for valid alphabetic characters in the license plate
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                licenseCounts[Character.toLowerCase(c) - 'a']++;
            }
        }
        
        String shortestWord = null;
        
        // 2. Evaluate each word in the array
        for (String word : words) {
            int[] wordCounts = new int[26];
            for (char c : word.toCharArray()) {
                wordCounts[c - 'a']++;
            }
            
            // 3. Check if the word satisfies all license plate requirements
            boolean isValid = true;
            for (int i = 0; i < 26; i++) {
                if (wordCounts[i] < licenseCounts[i]) {
                    isValid = false;
                    break;
                }
            }
            
            // 4. Update if it's valid and strictly shorter than our current best match
            if (isValid) {
                if (shortestWord == null || word.length() < shortestWord.length()) {
                    shortestWord = word;
                }
            }
        }
        
        return shortestWord;
    }
}