class Solution {
    public int rec(int i, String s, int n,int[] dp){
        if(i>=n) return 1;
        if(dp[i]!=-1) return dp[i];
        int x = 0;
        if(i<n){
            if(s.charAt(i)!='0')
            x = rec(i+1,s,n,dp);
        }
        int y = 0;
        if(i+1<n&&s.charAt(i)>'0'){
            if(s.charAt(i)=='1') y = rec(i+2,s,n,dp);
            else if(s.charAt(i)=='2'&&s.charAt(i+1)<'7') y = rec(i+2,s,n,dp);
        }

        return dp[i] =  x+y;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(0,s,n,dp);
    }
}