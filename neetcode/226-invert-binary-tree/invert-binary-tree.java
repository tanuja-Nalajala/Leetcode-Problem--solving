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
    TreeNode solve(TreeNode node){
        if(node == null  ) return node;

        TreeNode l = solve(node.left);
        TreeNode r = solve(node.right);
        
        node.left = r;
        node.right = l;
        return node;

    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        return solve(root);
    }
}