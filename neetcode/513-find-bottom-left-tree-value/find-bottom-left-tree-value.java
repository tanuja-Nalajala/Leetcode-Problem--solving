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
    class Pair{
        int level;
        TreeNode node;
        Pair(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        
        if(root == null)
            return -1;
        q.add(new Pair(0, root));
        
        int prevLevel = 0, val = root.val;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int level = p.level;
            TreeNode node = p.node;

            if(level > prevLevel ){
                prevLevel = level;
                val = node.val;
            }

            if(node.left != null)
                q.add(new Pair(level+1, node.left));
            if(node.right != null)
                q.add(new Pair(level+1, node.right));
        }
        return val;
    }
}