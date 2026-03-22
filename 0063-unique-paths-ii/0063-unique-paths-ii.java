class Solution {
    public int move(int i,int j,int m,int n,int[][] grid,int[][] dp){
        if(i>m||j>n||grid[i][j]==1) return 0;
        if(i==m&&j==n) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] =  move(i+1,j,m,n,grid,dp)+move(i,j+1,m,n,grid,dp);
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return move(0,0,m-1,n-1,grid,dp);
    }
}