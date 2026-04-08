class Solution {
    public long rec(int dis, int pas, int n,long[][] dp){
        if(dis==n) return 0;
        if(dis>n) return Integer.MAX_VALUE;
        if(dp[dis][pas]!=Integer.MAX_VALUE) return dp[dis][pas];
        long p = 1+rec(dis+pas,pas,n,dp);
        long pc = 2 + rec(dis+pas,dis+pas, n,dp);
        return dp[dis][pas] =  Math.min(p,pc);
    }
    public int minSteps(int n) {
        if(n==1) return 0;
        long[][] dp = new long[n+1][n+1];
        for(long[] r: dp)  Arrays.fill(r,Integer.MAX_VALUE);
        return 1 + (int)rec(1,1,n,dp);
    }
}