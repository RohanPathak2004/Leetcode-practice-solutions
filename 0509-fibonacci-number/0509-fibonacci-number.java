class Solution {
    public int fibDp(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] =  fibDp(n-1,dp)+fibDp(n-2,dp);
    }
    public int fib(int n) {
        if(n<=1) return n;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fibDp(n,dp); 
    }
}