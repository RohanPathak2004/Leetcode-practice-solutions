class Solution {
    public int combinationSum4(int[] nums, int tar) {
        int n = nums.length;
        int[] dp = new int[tar + 1];
        dp[0] = 1;
        for (int i = 1; i <= tar; i++) {
            int pick = 0;
            for (int idx = 0; idx < n; idx++) {
                if (i - nums[idx] >= 0)
                    pick += dp[i - nums[idx]];
            }
            dp[i] += pick;
        }
        // System.out.println(dp[tar]);
        return dp[tar];
    }
}