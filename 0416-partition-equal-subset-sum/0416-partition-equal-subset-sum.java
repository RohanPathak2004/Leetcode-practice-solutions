class Solution {
    public Boolean rec(int i,int sum,int tar,int[] nums,Boolean[][] dp){
        if(sum>tar) return false;
        if(i==nums.length){
            if(sum==tar) return true;
            return false;
        }
        if(dp[i][sum]!=null) return dp[i][sum];
        Boolean skip = rec(i+1,sum,tar,nums,dp);
        Boolean pick = rec(i+1,sum+nums[i],tar,nums,dp);
        return dp[i][sum] = skip||pick;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum%2==1) return false;
        Boolean[][] dp = new Boolean[nums.length][totalSum/2+1];
        return rec(0,0,totalSum/2,nums,dp);
    }
}