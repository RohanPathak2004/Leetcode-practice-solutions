class Solution {
    public long rec(int n,int k,int tar,int modulo,long[][] dp){
        if(n==0){
            if (tar==0) return 1;
            else return 0;
        }
        // if(tar<0) return 0;
        long ans = 0;
        if(dp[n][tar]!=-1) return dp[n][tar];
        for(int i = 1 ; i<=k ; i++){
            if(tar-i>=0) ans = (ans+rec(n-1,k,tar-i,modulo,dp))%modulo;
            else break;
        }
        return dp[n][tar] =  ans;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int modulo = 1_000_000_007;
        long[][] dp = new long[n+1][1001];
        for(long[] r:dp) Arrays.fill(r,-1);
        return (int)rec(n,k,target,modulo,dp);
    }
}