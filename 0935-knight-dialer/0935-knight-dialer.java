class Solution {
    public int modulo = 1_000_000_007;
    public long rec(int r, int c, int k,long[][][] dp) {
        if (r < 0 || c < 0 || r >= 4 || c >= 3 || (r == 3 && c == 0) || (r == 3 && c == 2))
            return 0;
        if (k == 0)
            return 1;
        // System.out.println(dial[r][c]);
        if(dp[k][r][c]!=-1) return dp[k][r][c];
        return dp[k][r][c] =  (rec(r + 1, c + 2, k - 1,dp)%modulo + rec(r + 1, c - 2, k - 1,dp)%modulo+
                              rec(r + 2, c + 1, k - 1,dp)%modulo + rec(r + 2, c - 1, k - 1,dp)%modulo +
                              rec(r - 1, c + 2, k - 1,dp)%modulo + rec(r - 1, c - 2, k - 1,dp)%modulo +
                              rec(r - 2, c - 1, k - 1,dp)%modulo + rec(r - 2, c + 1, k - 1,dp)%modulo)%modulo;
    }

    public int knightDialer(int n) {
        int num = 1;
        long val = 0;
        long[][][] dp =  new long[n][4][3];
        for(long[][] mat: dp){
            for(long[] c: mat){
                Arrays.fill(c,-1);
            }
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                val = (val+rec(i, j, n - 1,dp))%modulo;

            }
        }

        return (int)val;
    }
}