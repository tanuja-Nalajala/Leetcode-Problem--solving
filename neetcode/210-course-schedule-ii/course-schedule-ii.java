class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        int [] indegree = new int[numCourses];

        //construct adj
        //for adj : numcourses
        for(int i = 0; i < numCourses; ++i){
            adj.add(new ArrayList<>());
        }

        // adj & indegree
        for(int [] it : prerequisites){
            int course = it[0];
            int prereq = it[1];
            //edge is from prere - course
            adj.get(prereq).add(course);
            indegree[course]++;
        }

        //indegree = 0 ==> push to q
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i){
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] schedule = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            
            schedule[count++] = top;
            //remove edges
            for(int it : adj.get(top)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
        return (count == numCourses) ? schedule : new int[0];
    }
}