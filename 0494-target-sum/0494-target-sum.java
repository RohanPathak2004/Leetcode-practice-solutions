class Solution {
    public class Pair{
        int idx;
        int sum ;
        public Pair(int idx, int sum){
            this.idx = idx;
            this.sum = sum;
        }
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return idx == pair.idx && sum == pair.sum;
    }

    @Override
    public int hashCode() {
        // Objects.hash is a simple way to combine fields into a hash
        return Objects.hash(idx, sum);
    }

    }
    public int rec(int i, int cur, int tar, int[] nums, HashMap<Pair,Integer> map){
        if(i>=nums.length&&cur==tar) return 1;
        if(i>=nums.length) return 0;
        Pair p = new Pair(i, cur);
        if(map.containsKey(p)) return map.get(p);
        // int skip = rec(i+1, cur, tar, nums, dp);
        int pickPos = rec(i+1, cur+nums[i], tar, nums, map);
        int pickNeg = rec(i+1, cur-nums[i], tar, nums, map);
        // int ans =0 ;
        int ans  = pickPos+pickNeg;
        map.put(p,ans);
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        HashMap<Pair,Integer> map = new HashMap<>();
        int ans =  rec(0, 0, target, nums, map);
        return ans;
    }
}