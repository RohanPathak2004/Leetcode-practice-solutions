class Solution {
    public boolean  rec(int i,int cur,int tar, int n, int[] nums, Boolean[][] dp){
        if(cur>tar) return false;
        if(i==n){
            if(cur==tar) return true;
            return false;
        }
        if(dp[cur][i]!=null) return dp[cur][i];
        boolean skip = rec(i+1,cur,tar,n,nums,dp);
        boolean pick = rec(i+1,cur+nums[i],tar, n, nums,dp);
        return dp[cur][i] =  skip || pick;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).reduce(0,(a,b)->a+b);
        if(totalSum%2==1) return false;
        int n = nums.length;
        int tar = totalSum/2;
        Boolean[][] dp = new Boolean[tar+1][n+1];
        return rec(0,0,tar,nums.length,nums,dp);
    }
}