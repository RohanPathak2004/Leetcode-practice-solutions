class Solution {
    public String rev(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str += s.charAt(i) + "";
        }
        return str;
    }

    // public int lcs(int i, int j, String s, String str, int n, int[][] dp) {
    //     if (i >= n || j >= n)
    //         return 0;
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     if (s.charAt(i) == str.charAt(j)) {
    //         return dp[i][j] = 1 + lcs(i + 1, j + 1, s, str, n, dp);
    //     } else {
    //         return dp[i][j] = Math.max(lcs(i + 1, j, s, str, n, dp), lcs(i, j + 1, s, str, n, dp));
    //     }
    // }

    public int longestPalindromeSubseq(String s) {
        String str = rev(s);
        // System.out.println(revS);
        int n = s.length();
        int[][] dp = new int[n][n];
        // for(int[] r:dp) Arrays.fill(r,-1);
        for(int i = 0; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                int p = (i>=1&&j>=1)? dp[i-1][j-1]:0;
                int q = (i>=1)? dp[i-1][j]:0;
                int r = (j>=1)? dp[i][j-1]:0;
                if(s.charAt(i)==str.charAt(j)){
                    dp[i][j] =  1 + p;
                }else{
                    dp[i][j] =  Math.max(q,r);
                }
            }
        }
        return dp[n-1][n-1];
    }
}