
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base case 1: If root1 is null, the merged result is just root2
        if (root1 == null) {
            return root2;
        }
        
        // Base case 2: If root2 is null, the merged result is just root1
        if (root2 == null) {
            return root1;
        }
        
        // Step 1: Merge the values into root1 (in-place modification)
        root1.val += root2.val;
        
        // Step 2: Recursively merge the left subtrees
        root1.left = mergeTrees(root1.left, root2.left);
        
        // Step 3: Recursively merge the right subtrees
        root1.right = mergeTrees(root1.right, root2.right);
        
        // Return the updated root1 tree
        return root1;
    }
}