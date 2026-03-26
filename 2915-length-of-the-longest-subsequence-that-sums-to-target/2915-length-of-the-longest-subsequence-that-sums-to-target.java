class Solution {
    public int rec(int i, int tar, int n, List<Integer> nums, int[][] dp){
        if(i>=n&&tar==0) return 0;
        if(i>=n||tar<0) return Integer.MIN_VALUE;
        if(dp[i][tar]!=-1) return dp[i][tar];
        int skip = rec(i+1, tar, n, nums, dp);
        int pick = 1+ rec(i+1, tar-nums.get(i), n, nums, dp);
        return dp[i][tar] = Math.max(skip, pick);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int[][] dp = new int[n][target+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans =  rec(0,target,nums.size(),nums,dp);
        // System.out.println()
        return ans<=0?-1:ans;
    }
}