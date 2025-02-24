/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == null ) return null;
        int low = Math.min(p.val, q.val);
        int high = Math.max(p.val, q.val);
        
        if(root.val == low || root . val == high ) 
        {
            return root;
        }

        if((root.val > low && root.val < high) ) 
            return root;
        else if(root.val > low && root.val > high ){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}