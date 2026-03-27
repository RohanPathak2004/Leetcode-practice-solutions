class Solution {
    // class Pair {
    //     int idx;
    //     boolean iseven;

    //     public Pair(int idx, boolean iseven) {
    //         this.idx = idx;
    //         this.iseven = iseven;
    //     }

    //     @Override
    //     public boolean equals(Object o) {
    //         Pair p = (Pair) o;
    //         return idx == p.idx && iseven == p.iseven;
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(idx, iseven);
    //     }
    // }

    public long rec(int i, int evenParaty, int x, int n, int[] nums, long[][] dp) {
        if (i >= n)
            return 0;
        if(dp[i][evenParaty]!=-1) return dp[i][evenParaty];
        long skip = rec(i + 1, evenParaty, x, n, nums, dp);
        
        long pick = nums[i] + rec(i + 1, nums[i]%2, x, n, nums, dp);
        if (nums[i] % 2 != evenParaty) {
            pick = pick - x;
        }

        return dp[i][evenParaty] = Math.max(skip, pick);
        
    }

    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        // long total = Arrays.stream(nums).reduce(0,(a,b)->a+b);
        // long[][] dp = new long[n][n];
        long[][] dp = new long[n][2];
        for (long[] row : dp)
            Arrays.fill(row, -1);
        return nums[0] + rec(1, nums[0]%2, x, n, nums, dp);
    }
}