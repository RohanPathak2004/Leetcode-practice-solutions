class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double sum = 0;
        double maxAvg = Integer.MIN_VALUE;
        int i = 0;
        int j = i;
        while(j<k){
            sum+=nums[j++];
        }
        maxAvg = Math.max(sum/k,maxAvg);
        
        while(j<n){
            
            sum+= nums[j]-nums[i];
            maxAvg = Math.max(sum/k,maxAvg);
            i++;
            j++;
            
        }
        return maxAvg;
    }
}