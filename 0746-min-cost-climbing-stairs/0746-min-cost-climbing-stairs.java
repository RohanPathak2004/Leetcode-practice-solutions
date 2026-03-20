class Solution {
    public int  mincost(int []cost , int i , int []dp){
        if(i==0||i==1) return cost[i]; 
        if(dp[i]!=-1) return dp[i];
        int ans = cost[i]+Math.min(mincost(cost,i-1,dp),mincost(cost,i-2,dp));
        // dp[i] = ans;
        return dp[i] = ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        int []dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(mincost(cost,cost.length-1,dp),mincost(cost,cost.length-2,dp));
    }
}