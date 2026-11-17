
class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the height helper doesn't return -1, the tree is balanced
        return getHeight(root) != -1;
    }
    
    // Helper method that returns the height of a node, or -1 if unbalanced
    private int getHeight(TreeNode node) {
        // Base case: An empty tree has a height of 0 and is balanced
        if (node == null) {
            return 0;
        }
        
        // Get the height of the left subtree
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1; // Propagate unbalance flag upwards
        
        // Get the height of the right subtree
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1; // Propagate unbalance flag upwards
        
        // If the current node's subtrees differ in height by more than 1, it's unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        
        // Otherwise, return the actual height of this node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}