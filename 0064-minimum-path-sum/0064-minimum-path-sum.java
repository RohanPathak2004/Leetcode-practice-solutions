class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i<m ; i++){
            for(int j = 0; j<n ; j++){
                int left = (j>0)? dp[i][j-1]:Integer.MAX_VALUE;
                int top = (i>0)? dp[i-1][j]:Integer.MAX_VALUE;
                if(i==0&&j==0) dp[i][j] = grid[i][j];
                else dp[i][j] =  grid[i][j] + Math.min(left, top);
            }
        }
        return dp[m-1][n-1];
    }
}