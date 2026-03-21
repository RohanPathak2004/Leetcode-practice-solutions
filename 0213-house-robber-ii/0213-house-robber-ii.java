class Solution {
    public int rec(int n,int stop,int[] nums,int[] dp){
        if(n<stop) return 0;
        if(n==stop) return nums[n];
        int a;
        int b;
        if(n-2>=stop&&dp[n-2]!=-1) a = dp[n-2];
        else a = rec(n-2,stop,nums,dp);

        if(n-1>=stop&&dp[n-1]!=-1) b = dp[n-1];
        else b = rec(n-1,stop,nums,dp);

        return dp[n] =  Math.max(nums[n]+a,b);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int a = rec(n-1,1,nums,dp);
        Arrays.fill(dp,-1);
        int b = rec(n-2,0,nums,dp);
        return Math.max(a,b);
    }
}