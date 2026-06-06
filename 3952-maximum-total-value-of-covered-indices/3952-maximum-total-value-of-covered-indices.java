class Solution {
    public long rec(int i, int prev,int[] nums,String s,long[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][prev]!=-1) return dp[i][prev];
        if(s.charAt(i)=='0') return dp[i][prev] = rec(i+1,s.charAt(i)-48,nums,s,dp);
        else{
            long no_pick = rec(i+1,s.charAt(i)-48,nums,s,dp)+nums[i];
            long pick  = 0;
            if(prev==0){
                pick =nums[i-1]+rec(i+1,0,nums,s,dp);
            }
            return dp[i][prev] = Math.max(no_pick,pick);
        }
    }
    public long maxTotal(int[] nums, String s) {
        long[][] dp = new long[nums.length][2];
        for(long[] r:dp) Arrays.fill(r,-1);
        return rec(1,s.charAt(0)-48,nums,s,dp)+(s.charAt(0)=='1'?nums[0]:0);
    }
}