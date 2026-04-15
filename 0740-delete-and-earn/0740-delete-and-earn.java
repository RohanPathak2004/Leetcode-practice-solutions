class Solution {
    public int rec(int i, int n, int[] nums, int[] freq,int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int skip = rec(i+1,n,nums,freq,dp);
        int point = nums[i]*freq[i];
        int idx = 0;
        if(i+1<n&&(nums[i+1]==nums[i]+1)) idx = i+2;
        else idx = i+1;
        int pick = point+rec(idx,n,nums,freq,dp);
        // System.out.println(skip+" "+pick);
        return dp[i] = Math.max(skip,pick);
    }
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele: nums) map.compute(ele,(k,v)->v==null?1:v+1);
        int n = map.size();
        int[] arr = new int[n];
        int[] freq = new int[n];
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        int idx = 0;
        for(int i = 0; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                arr[idx] = nums[i];
                freq[idx] = map.get(nums[i]);
                map.remove(nums[i]);
                idx++;
            }
        }
        
        return rec(0,n,arr,freq,dp);
    }
}