class Solution {
    public int rec(int n,int[] nums,int[] dp){
        if(n<0) return 0;
        if(n==0) return nums[n];
        int x;
        int y;
        if(n-2>=0&&dp[n-2]!=-1) x = dp[n-2];
        else x = rec(n-2,nums,dp);
        if(n-1>=0&&dp[n-1]!=-1) y = dp[n-1];
        else y = rec(n-1,nums,dp); 
        return dp[n] =  Math.max(nums[n]+x,y);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.max(rec(n-1,nums,dp),rec(n-2,nums,dp));
    }
}