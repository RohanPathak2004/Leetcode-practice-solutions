class Solution {
    public long rec(int prev, int count,  int n,long[][][] dp, int[] roll,int modulo) {
        if(count>roll[prev]) return 0;
        if (n == 0)
            return 1;
        long ans = 0;
        if(dp[n][prev][count]!=-1) return dp[n][prev][count];
        for (int idx = 0; idx < 6; idx++) {
            if(prev==idx) ans = (ans+rec(idx,count+1,n-1,dp,roll,modulo))%modulo;
            else{
                ans = (ans+rec(idx,1,n-1,dp,roll,modulo))%modulo;
            }
        }
        return dp[n][prev][count] =  ans;
    }

    public int dieSimulator(int n, int[] rollMax) {
        int val = 0;
        int modulo = 1_000_000_007;
        int max = Arrays.stream(rollMax).reduce(0,(a,b)->Math.max(a,b));
        long[][][] dp = new long[n+1][6][max+1];
        for(long[][] mat:dp){
            for(long[] c:mat) Arrays.fill(c,-1);
        }
        
        return (int)rec(0,0,n,dp,rollMax,modulo);
    }
}