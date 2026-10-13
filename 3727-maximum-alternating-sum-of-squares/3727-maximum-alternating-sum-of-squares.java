class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long psum = 0;
        long nsum = 0;
        for(int i = 0; i<n ; i++) nums[i] = nums[i]*nums[i];
        Arrays.sort(nums);
        for(int i = n/2; i<n ; i++) psum += nums[i];
        for (int i = 0 ; i<n/2 ; i++) nsum += nums[i];
        return psum-nsum;
    }
}