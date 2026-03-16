class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
       List<List<Integer>> adj = new ArrayList<>();
       int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; ++i){
            adj.add(new ArrayList<>());
        }
        for(int []it : prerequisites){
            int course = it[0];
            int preReq = it[1];
            //edge is b/w prereq -> course
            adj.get(preReq).add(course);
            indegree[course]++;
        }

        //push indegree with 0 onto q
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; ++i){
            if(indegree[i] == 0)
                q.add(i);
        }
        int count = 0;
        List<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            topo.add(top);
            count++;
            //added this to my topo
            //will remove from q + also remove edges
            //q.remove();
            for(int it : adj.get(top)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }

        return (count == numCourses);
    }
}