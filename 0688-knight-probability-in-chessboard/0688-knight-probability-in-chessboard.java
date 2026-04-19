class Solution {
    public double rec(int r,int c, int k,int n,double[][][] dp){
        if(k<0||r<0||r>=n||c<0||c>=n) return 0;
        if(k==0) return 1;
        if(dp[k][r][c]!=-1) return dp[k][r][c];
        return dp[k][r][c] =  rec(r+1,c+2,k-1,n,dp)+rec(r+1,c-2,k-1,n,dp)+rec(r+2,c+1,k-1,n,dp)+
                              rec(r+2,c-1,k-1,n,dp)+rec(r-1,c+2,k-1,n,dp)+rec(r-1,c-2,k-1,n,dp)+
                              rec(r-2,c-1,k-1,n,dp)+rec(r-2,c+1,k-1,n,dp);
    }
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k+1][n][n];
        for(double[][] td:dp){
            for(double[] a:td) Arrays.fill(a,-1);
        }
        double noOfWays = rec(row,column,k,n,dp);
        return noOfWays/Math.pow(8,k);
    }
}