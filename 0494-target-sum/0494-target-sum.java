class Solution {
    public int rec(int i,int sum,int[] nums, int n, int tar,int totalSum,int[][] dp){
        if(i>=n){
            if(sum==tar) return 1;
            return 0;
        }

        int idx = sum+totalSum;
        if(dp[i][idx]!=Integer.MAX_VALUE) return dp[i][idx];
        int pos = rec(i+1,sum+nums[i],nums,n,tar,totalSum,dp);
        int neg = rec(i+1,sum-nums[i],nums,n,tar,totalSum,dp);
        
        return dp[i][idx] = pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).reduce(0,(a,b)->a+b);
        int[][] dp = new int[n][2*sum+1];
        for(int[] r:dp) Arrays.fill(r,Integer.MAX_VALUE);
        return rec(0,0,nums,n,target,sum,dp);
    }
}