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
    class Tuple{
        TreeNode node;
        int x;
        int y;
        Tuple(TreeNode node, int x, int y){
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer> > > tm = new TreeMap<>();

        q.add(new Tuple(root, 0,0));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.x;
            int y = t.y;
            //since we need to get elements in the sorted order of columns
            //we want -2, -1, 0, 1, 2 elements
            tm.putIfAbsent(x, new TreeMap<>());
            tm.get(x).putIfAbsent(y, new PriorityQueue<>());
             tm.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.add(new Tuple(node.left, x-1, y+1));
            }
            if(node.right != null){
                q.add(new Tuple(node.right, x+1, y+1));
            }
        }

        //i need valued sorted in order of their cols
        for(TreeMap<Integer, PriorityQueue<Integer> > cols : tm.values()){
           List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : cols.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;

    }
}