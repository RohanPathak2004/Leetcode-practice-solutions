class Solution {
    public int rec(int i,int tar, int n, int[] nums, int[][] dp){
        if(tar==0) return 1;
        if(tar<0) return 0;
        if(dp[i][tar]!=-1) return dp[i][tar];
        int pick = 0;
        for(int idx = 0 ;idx<n ; idx++){
            pick += rec(idx,tar-nums[idx],n,nums,dp);
        }
        return dp[i][tar] =  pick;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        
        for(int[] r:dp) Arrays.fill(r,-1);
        return rec(0,target,n,nums,dp);
    }
}