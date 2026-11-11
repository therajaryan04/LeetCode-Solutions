
class Solution {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        // Base case: if node is null or we already found the answer, return early
        if (node == null || result != -1) {
            return;
        }

        // 1. Traverse left subtree (smaller elements)
        inorder(node.left);

        // 2. Process current node
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        // 3. Traverse right subtree (larger elements) if not found yet
        inorder(node.right);
    }
}