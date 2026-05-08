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
    //This stores the inorder val with its index for O(1) lookup
    private Map<Integer, Integer> preMap = new HashMap<>();
    //This stores the preOrder index
    private int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //adding all values in inorder to map
        for(int i=0;i<inorder.length;i++){
            preMap.put(inorder[i] , i);
        }
        return helper(preorder , 0 , inorder.length-1);
    }

    public TreeNode helper(int[] preorder , int low , int high){
        //over flow condition
        if(low > high) return null;

        //Since always preorder contains root first the left the right
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        //This is to get the cut of array to find left and right subtree
        int mid = preMap.get(rootVal);

        //left subtree from low to cut
        root.left = helper(preorder , low , mid-1);
        //right subtree from cut to low
        root.right = helper(preorder , mid+1 , high);

        return root;
    }
}
