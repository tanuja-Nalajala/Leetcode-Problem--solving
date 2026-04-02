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
    void createParentMap(TreeNode node, Map<TreeNode, TreeNode>pm){
        //use bfs;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            if(top.left != null){
                pm.put(top.left, top);
                q.add(top.left);
            }
            if(top.right != null){
                pm.put(top.right, top);
                q.add(top.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //at a given target node, we need tocount its left, right and also parent
        // since these are tree structures,no pointer is from leaf to parent
        //create a map from node - parent
        Map<TreeNode, TreeNode> pm = new HashMap<>();
        pm.put(root, root);
        createParentMap(root, pm);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        int currDist = 0;
        Map<TreeNode, Integer> vis = new HashMap<>();
        vis.put(target, 1);
        while(!q.isEmpty()){
            if(currDist == k)
                break;
            //left
            int size = q.size();
            for(int i = 0; i < size; ++i){
                 TreeNode node = q.poll();
                //left
                if(node.left != null && vis.get(node.left) == null ){
                    q.add(node.left);
                    vis.put(node.left,  1);
                }

                //right
                if(node.right != null && vis.get(node.right) == null ){
                    q.add(node.right);
                     vis.put(node.right, 1);
                }

                if(pm.get(node) != null && vis.get(pm.get(node)) == null )
                {
                    q.add(pm.get(node));
                     vis.put(pm.get(node), 1);
                }
            }
            currDist++;

        } 
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            ans.add(node.val);
        }
        return ans;
    }
}