class Solution {
    public String rev(String s){
        String str = "";
        for(int i = s.length()-1 ; i>=0 ;i--){
            str+=s.charAt(i)+"";
        }
        return str;
    }

    public int lcs(int i, int j,String s, String str,int n,int[][] dp){
        if(i>=n||j>=n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==str.charAt(j)){
            return dp[i][j] =  1 + lcs(i+1,j+1,s,str,n,dp);
        }else{
            return dp[i][j] =  Math.max(lcs(i+1,j,s,str,n,dp),lcs(i,j+1,s,str,n,dp));
        }
    }

    public int longestPalindromeSubseq(String s) {
        String revS = rev(s);
        // System.out.println(revS);
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] r:dp) Arrays.fill(r,-1);
        return lcs(0,0,s,revS,n,dp);
    }
}