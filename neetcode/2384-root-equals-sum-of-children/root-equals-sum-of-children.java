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
    boolean ans = true;
    int check(TreeNode root){
        if(root == null)
            return 0;
        //leaf
        if(root.left == null && root.right ==null)
            return root.val;
        int left = check(root.left);
        int right = check(root.right);
        if(left == (int)1e9 || right == (int)1e9)
            ans = false;
        if(root.val == left + right){
            return root.val;
        }
        else return (int)1e9;
    }
    public boolean checkTree(TreeNode root) {
        //
        return root.val == root.left.val + root.right.val;
    }
}