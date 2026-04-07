class Solution {
    public int upperBound(int tar,int[] arr){
        int l = 0;
        int h = arr.length;
        while(l<h){
            int mid = (l+h)/2;
            if(arr[mid]<=tar) l = mid+1;
            else h = mid;
        }
        return l;
    }
    public int rec(int i,int[] day,int[] cost,int[] dp){
        if(i>=day.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int ans = Integer.MAX_VALUE;
        int nextDay = day[i];
        int idx = upperBound(nextDay,day);
        int one = cost[0]+rec(idx,day,cost,dp);
        nextDay = day[i]+6;
        idx = upperBound(nextDay,day);
        int seven = cost[1]+rec(idx,day,cost,dp);
        nextDay = day[i]+29;
        idx = upperBound(nextDay,day);
        int thirty = cost[2]+rec(idx,day,cost,dp);
        return dp[i] =  Math.min(one,Math.min(seven,thirty));
    }
    public int mincostTickets(int[] day, int[] cost) {
        int n = day.length;
        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return rec(0,days,costs,dp);

        for(int i = n-1 ; i>=0 ; i--){
        int ans = Integer.MAX_VALUE;
        int nextDay = day[i];
        int idx = upperBound(nextDay,day);
        int one = cost[0]+dp[idx];
        nextDay = day[i]+6;
        idx = upperBound(nextDay,day);
        int seven = cost[1]+dp[idx];
        nextDay = day[i]+29;
        idx = upperBound(nextDay,day);
        int thirty = cost[2]+dp[idx];
        dp[i] =  Math.min(one,Math.min(seven,thirty));
        }

        return dp[0];
    }
}