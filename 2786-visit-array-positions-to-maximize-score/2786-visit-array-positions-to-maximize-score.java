class Solution {
    class Pair {
        int idx;
        boolean iseven;

        public Pair(int idx, boolean iseven) {
            this.idx = idx;
            this.iseven = iseven;
        }

        @Override
        public boolean equals(Object o) {
            Pair p = (Pair) o;
            return idx == p.idx && iseven == p.iseven;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idx, iseven);
        }
    }

    public long rec(int i, boolean evenParaty, int x, int n, int[] nums, HashMap<Pair, Long> dp) {
        if (i >= n)
            return 0;
        Pair p = new Pair(i, evenParaty);
        if (dp.containsKey(p)) {
            // System.out.println("working...");
            return dp.get(p);
        }
        long skip = rec(i + 1, evenParaty, x, n, nums, dp);
        
        long pick = nums[i] + rec(i + 1, nums[i]%2==0, x, n, nums, dp);
        if ((nums[i] % 2==0) != evenParaty) {
            pick = pick - x;
        }

        long ans = Math.max(skip, pick);
        dp.put(new Pair(i, evenParaty), ans);
        return ans;
    }

    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        // long total = Arrays.stream(nums).reduce(0,(a,b)->a+b);
        // long[][] dp = new long[n][n];
        HashMap<Pair, Long> dp = new HashMap<>();
        // for (long[] row : dp)
        //     Arrays.fill(row, -1);
        return nums[0] + rec(1, nums[0]%2==0, x, n, nums, dp);
    }
}