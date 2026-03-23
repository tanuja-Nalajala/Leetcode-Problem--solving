class Solution {
    int solve(int[][]jobs, int ind, int[]dp, int n){
        if(ind >= n) return 0;

        if(dp[ind] != -1) return dp[ind];
        //i can skip the job
        int skip = 0 + solve(jobs, ind+1, dp, n);

        //i can pick the job
        //i need to know the jobs which are available to after endtime of this job
        int targetEnd = jobs[ind][1];
        int nextId = getNextJob(jobs, ind, n, targetEnd);
        int pick = jobs[ind][2] + solve(jobs, nextId, dp, n);

        return dp[ind] = Math.max(skip, pick);
    }
    int getNextJob(int[][]jobs, int ind, int n, int targetStart){
        //since jobs is sorted in order of their starting times
        //i can make use of binary search
        int l = ind, r = n, ans = 0;
        while(l < r){
            int mid = l + (r -l)/2;
            if(jobs[mid][0] < targetStart){
                // id: mid start time is < the required
                //move forwrd
                l = mid + 1;
            }else{
                //mid: start time >= required
                //can be my id
                //check are thre any other job id's less than this
                r = mid;
            }
        }
        return l;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int [][] jobs = new int[n][3];
         int []dp = new int[n];
         Arrays.fill(dp, -1);

        for(int i = 0; i < n; ++i){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        //sort these jobs in order their starting time
        Arrays.sort( jobs, (a,b) -> (a[0] - b[0]) );

        return solve(jobs, 0, dp, n);
    }
}