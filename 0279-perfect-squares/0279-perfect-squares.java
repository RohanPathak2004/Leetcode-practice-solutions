class Solution {
    public long rec(int i,long n,int len,int[] sqrs,long[] dp){
        if(n<0||i>=len) return Integer.MAX_VALUE;
        if(n==0) return 0;
        if(dp[(int)n]!=0) return dp[(int)n];
        long pick = 1+Math.min(rec(i,n-sqrs[i],len,sqrs,dp),rec(i+1,n-sqrs[i],len,sqrs,dp));
        long unpick = rec(i+1,n,len,sqrs,dp);
        return dp[(int)n] =  Math.min(pick,unpick);
    }
    public int numSquares(int n) {
        // System.out.println((int)Math.sqrt(n/2)+1);
        int val = (int)Math.sqrt(n);
        if(val*val==n) return 1;
        int len = val+1;
        int[] sqrs = new int[len];
        long[] dp = new long[n+1];
        for(int i = 0; i<len ;i++){
            sqrs[i] = (i+1)*(i+1);
            // System.out.println(sqrs[i]);
        }
        long minStep = rec(0,n,len,sqrs,dp);
        
        return (int)minStep;
    }
}