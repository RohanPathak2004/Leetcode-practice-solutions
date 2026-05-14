class Solution {
    int modulo = 1_000_000_007;
    public long rec(int n,long[] dp){
        if(n<=0) return 1;
        if(n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = (rec(n-1,dp)*2+rec(n-3,dp))%modulo;
    }
    public int numTilings(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);
        return (int)rec(n,dp);
    }
}