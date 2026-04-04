class Solution {
    public String rev(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str += s.charAt(i) + "";
        }
        return str;
    }
    public int longestPalindromeSubseq(String s) {
        String str = rev(s);        
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i<=n ; i++){
            for(int j = 1 ; j<=n ; j++){
                if(s.charAt(i-1)==str.charAt(j-1))  dp[i][j] =  1 + dp[i-1][j-1];
                else dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
}