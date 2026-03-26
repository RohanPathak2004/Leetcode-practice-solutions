class Solution {
    public long rec(int i, int amount, int[] coins, long[][] dp){
        if(i>=coins.length&&amount==0) return 0;
        if(i>=coins.length||amount<0) return Integer.MAX_VALUE;
        if(dp[i][amount]!=-1) return dp[i][amount];
        long skip = rec(i+1, amount, coins, dp);
        long pick = 1+rec(i+1 ,amount-coins[i], coins, dp);
        long pickRepeat = 1+rec(i, amount-coins[i], coins, dp);
        return dp[i][amount] =  Math.min(skip, Math.min(pick, pickRepeat));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[][] dp = new long[n][amount+1];
        for(long[] row:dp) Arrays.fill(row,-1);
        long ans = rec(0,amount,coins,dp);
        return (ans==Integer.MAX_VALUE?-1:(int)ans);
    }
}