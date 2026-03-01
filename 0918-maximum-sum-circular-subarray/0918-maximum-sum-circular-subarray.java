class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int totalSum = nums[0];
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int curr_max_sum =nums[0];
        int curr_min_sum = nums[0];
        for(int i = 1; i<n ;i++){
            totalSum+=nums[i];
            if(curr_max_sum>=0){
                curr_max_sum+=nums[i];
            }else{
                curr_max_sum = nums[i];
            }

            if(curr_min_sum<=0){
                curr_min_sum += nums[i];
            }else{
                curr_min_sum = nums[i];
            }

            maxSum = Math.max(maxSum,curr_max_sum);
            minSum = Math.min(minSum,curr_min_sum);

        }


            maxSum = Math.max(maxSum,curr_max_sum);
            minSum = Math.min(minSum,curr_min_sum);

            // System.out.println(maxSum+" "+minSum);

        return Math.max(maxSum,(totalSum-minSum)==0?Integer.MIN_VALUE:(totalSum-minSum));

    }
}