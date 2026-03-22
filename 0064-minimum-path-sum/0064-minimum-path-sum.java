class Solution {
    public int minSum(int i, int j, int m, int n, int[][] grid,int[][] dp) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return grid[0][0];
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n] =  grid[m][n] + Math.min(minSum(i, j, m, n - 1, grid,dp), minSum(i, j, m - 1, n, grid,dp));
        
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return minSum(0, 0, m - 1, n - 1, grid,dp);
    }
}