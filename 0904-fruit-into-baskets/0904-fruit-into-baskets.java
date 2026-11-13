import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int left = 0;
        
        // HashMap to store the count of each fruit type in the current window
        Map<Integer, Integer> fruitCount = new HashMap<>();
        
        for (int right = 0; right < fruits.length; right++) {
            // Add the current fruit to our basket window
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            
            // If we have more than 2 types of fruit, shrink the window from the left
            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                fruitCount.put(leftFruit, fruitCount.get(leftFruit) - 1);
                
                // If the count of the left fruit drops to zero, remove it from the map
                if (fruitCount.get(leftFruit) == 0) {
                    fruitCount.remove(leftFruit);
                }
                
                left++; // Move the left pointer forward
            }
            
            // Track the maximum number of fruits collected so far
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}