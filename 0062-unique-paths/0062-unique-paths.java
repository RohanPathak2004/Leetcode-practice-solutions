class Solution {
    public int rec(int i, int j, int m, int n,int[][] dp) {
        if (i > m || j > n)
            return 0;
        if (i == m && j == n)
            return 1;

        if(dp[i][j]!=-1) return dp[i][j];
        return dp[i][j] =  rec(i + 1, j, m, n,dp) + rec(i, j + 1, m, n,dp);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return rec(0, 0, m - 1, n - 1, dp);
    }
}