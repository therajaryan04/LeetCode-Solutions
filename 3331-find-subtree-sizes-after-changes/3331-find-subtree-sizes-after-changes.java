import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> originalTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            originalTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            originalTree.get(parent[i]).add(i);
        }

        int[] newParent = Arrays.copyOf(parent, n);
        int[] closestAncestor = new int[26];
        Arrays.fill(closestAncestor, -1);

        // Pass 1: Determine new parents based on original ancestor paths
        reassignParents(0, s, originalTree, closestAncestor, newParent);

        // Build the restructured tree from newParent
        List<List<Integer>> updatedTree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            updatedTree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            updatedTree.get(newParent[i]).add(i);
        }

        // Pass 2: Calculate subtree sizes in the updated tree
        int[] ans = new int[n];
        computeSubtreeSize(0, updatedTree, ans);
        return ans;
    }

    private void reassignParents(int node, String s, List<List<Integer>> tree,
                                 int[] closestAncestor, int[] newParent) {
        int charIdx = s.charAt(node) - 'a';
        int prevClosest = closestAncestor[charIdx];

        // Reassign parent if a matching ancestor exists on the current path
        if (prevClosest != -1) {
            newParent[node] = prevClosest;
        }

        // Mark current node as the closest matching ancestor for its subtree
        closestAncestor[charIdx] = node;

        for (int child : tree.get(node)) {
            reassignParents(child, s, tree, closestAncestor, newParent);
        }

        // Backtrack: restore the ancestor state for other branches
        closestAncestor[charIdx] = prevClosest;
    }

    private int computeSubtreeSize(int node, List<List<Integer>> tree, int[] ans) {
        int size = 1; // Count the node itself
        for (int child : tree.get(node)) {
            size += computeSubtreeSize(child, tree, ans);
        }
        ans[node] = size;
        return size;
    }
}