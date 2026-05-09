class Solution {
    // 1. Initialize to MIN_VALUE to handle trees with only negative nodes
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        // 2. Recursively get the max path from subtrees
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);

        // 3. If a subtree returns a negative sum, ignore it (take 0)
        leftMax = Math.max(leftMax, 0);
        rightMax = Math.max(rightMax, 0);

        // 4. Update the global maximum by "splitting" at the current node
        // This considers the path: Left Branch + Node + Right Branch
        res = Math.max(res, root.val + leftMax + rightMax);

        // 5. Return the "single branch" sum to the parent
        // A parent can only use ONE branch to continue its own path
        return root.val + Math.max(leftMax, rightMax);
    }
}