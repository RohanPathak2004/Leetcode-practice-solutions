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
        int[][] dp = new int[n][n];
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