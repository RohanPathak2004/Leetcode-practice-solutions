class Solution {
    public int rec(int i, int sum,int totalSum, int[] s, int n, int[][] dp){
        if(i>=n){
            // System.out.println(sum+" "+totalSum);
            return Math.abs(totalSum-2*sum);
        }
        if(dp[i][sum]!=-1) return dp[i][sum];
        int skip = rec(i+1,sum,totalSum,s,n,dp);
        int pick = rec(i+1,sum+s[i],totalSum,s,n,dp);
        return dp[i][sum] = Math.min(skip,pick);
    }
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).reduce(0,(a,b)->a+b);
        int[][] dp = new int[n][sum];
        for(int[] r:dp) Arrays.fill(r,-1);
        return rec(0,0,sum,stones,n,dp);
    }
}