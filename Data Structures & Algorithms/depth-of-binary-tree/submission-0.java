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
    public int maxDepth(TreeNode root) {
        int res = helper(root , 0);
        return res;
    }

    public int helper(TreeNode root , int hight){
        if(root == null) return hight;
        return Math.max(helper(root.left , hight+1) , helper(root.right , hight+1));
    }
}
