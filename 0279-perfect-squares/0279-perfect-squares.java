class Solution {
    public int rec(int i,int n,int len,int[] sqrs,int[] dp){
        if(n<0||i>=len) return 100000;
        if(n==0) return 0;
        if(dp[n]!=0) return dp[n];
        int pick = 1+rec(i,n-sqrs[i],len,sqrs,dp);
        int unpick = rec(i+1,n,len,sqrs,dp);
        return dp[n] =  Math.min(pick,unpick);
    }
    public int numSquares(int n) {
        // System.out.println((int)Math.sqrt(n/2)+1);
        int val = (int)Math.sqrt(n);
        if(val*val==n) return 1;
        int len = val+1;
        int[] sqrs = new int[len];
        int[] dp = new int[n+1];
        for(int i = 0; i<len ;i++){
            sqrs[i] = (i+1)*(i+1);
            // System.out.println(sqrs[i]);
        }
        int minStep = rec(0,n,len,sqrs,dp);
        
        return minStep;
    }
}