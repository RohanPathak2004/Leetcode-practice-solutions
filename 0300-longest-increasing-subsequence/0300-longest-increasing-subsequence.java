class Solution {
    public int lengthOfLIS(int[] nums) {
        //the key idea of the solution is to find the max len
        //of the seq at ith ele and the move forward.
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 0;
        for(int i = 0; i<n ; i++) {
            //compare every with nums[i] before i
            for(int j = 0; j<i ; j++){
                if(nums[j]<nums[i]) { // condition for LIS
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i]++; // for adding the ith ele in the seq itself.
            maxLen = Math.max(maxLen,dp[i]);
        }

        return maxLen;
    }
}