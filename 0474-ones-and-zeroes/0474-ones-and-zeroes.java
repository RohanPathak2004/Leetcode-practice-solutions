class Solution {
    
    public int rec(int i,int zeros,int ones, int m, int n, String[] strs, int len,int[][][] dp){
        if(zeros>m||ones>n) return Integer.MIN_VALUE;
        if(i>=len){
            return 0;
        }
        
        if(dp[i][zeros][ones]!=-1) return dp[i][zeros][ones];
        int skip = rec(i+1,zeros,ones,m,n,strs,len,dp);
        int x = 0;
        int y = 0;
        String s = strs[i];
        for(int idx = 0; idx<s.length() ; idx++){
            if(s.charAt(idx)=='0') x++;
            else y++;
        }
        int pick =1+ rec(i+1,zeros+x,ones+y,m,n,strs,len,dp);
        int ans =  Math.max(skip,pick);
       
        return dp[i][zeros][ones] = ans;

    }
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][101][101];
        for(int[][] x: dp){
            for(int[] y: x) Arrays.fill(y,-1);
        }
        return rec(0,0,0,m,n,strs,len,dp);
    }
}