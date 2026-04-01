class Solution {
    public int rec(StringBuilder st1,StringBuilder st2,int m, int n,int[][] dp){
        if(m<0||n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(st1.charAt(m)==st2.charAt(n)){
            return dp[m][n] = 1+ rec(st1,st2,m-1,n-1,dp);
        }else{
            return dp[m][n] =  Math.max(rec(st1,st2,m,n-1,dp),rec(st1,st2,m-1,n,dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder st1 = new StringBuilder(text1);
        StringBuilder st2 = new StringBuilder(text2);
        int[][] dp = new int[st1.length()][st2.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        return rec(st1,st2,st1.length()-1,st2.length()-1,dp);
    }
}