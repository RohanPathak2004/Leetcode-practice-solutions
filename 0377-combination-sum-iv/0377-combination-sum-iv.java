class Solution {
    public int rec(int tar, int n, int[] nums, int[] dp){
        if(tar==0) return 1;
        if(tar<0) return 0;
        if(dp[tar]!=-1) return dp[tar];
        int pick = 0;
        for(int idx = 0 ;idx<n ; idx++){
            pick += rec(tar-nums[idx],n,nums,dp);
        }
        return dp[tar] =  pick;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return rec(target,n,nums,dp);
    }
}