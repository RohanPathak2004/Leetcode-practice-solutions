class Solution {
    public int rec(int i, int cur, int tar, int[] nums, int[][] dp){
        if(i>=nums.length&&cur==tar) return 1;
        if(i>=nums.length) return 0;
        if(dp[i][Math.abs(cur+1000)]!=Integer.MIN_VALUE) return dp[i][Math.abs(cur+1000)];
        // int skip = rec(i+1, cur, tar, nums, dp);
        int pickPos = rec(i+1, cur+nums[i], tar, nums, dp);
        int pickNeg = rec(i+1, cur-nums[i], tar, nums, dp);
        int ans ;
        if(pickPos>=0&&pickNeg>=0) ans = pickPos+pickNeg;
        else if(pickPos>=0) ans = pickPos;
        else ans = pickNeg;
        return dp[i][Math.abs(cur+1000)] = ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2*1000+1];
        for(int[] row: dp) Arrays.fill(row,Integer.MIN_VALUE);
        int ans =  rec(0, 0, target, nums, dp);
        return ans;
    }
}