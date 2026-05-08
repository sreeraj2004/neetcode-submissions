/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        dfs(arr , root);
        return arr.get(k-1);
    }

    public void dfs(List<Integer> arr , TreeNode node){
        if(node == null) return;
        dfs(arr , node.left);
        arr.add(node.val);
        dfs(arr , node.right);
    }
}
