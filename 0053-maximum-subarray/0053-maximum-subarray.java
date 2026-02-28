class Solution {
    public int maxSubArray(int[] nums) {

        //this is kadane's algorithm

        int n = nums.length;
        if(n==1) return nums[0];
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i<n ; i++){
            if(currSum>=0){
                currSum+=nums[i];
                
            }else
            {
                currSum = nums[i];
            }
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum = Math.max(currSum,maxSum);
    }
}