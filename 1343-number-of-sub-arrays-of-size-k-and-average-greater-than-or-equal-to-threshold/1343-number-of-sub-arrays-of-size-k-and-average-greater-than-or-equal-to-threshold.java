class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int count = 0;
        while(j<k){
            sum+=nums[j];
            j++;
        }
        j--;
        while(j<n){
            double avg = (double)sum/k;
            System.out.println(sum);
            if(avg>=(double)threshold) count++;
            j++;
            if(j<n) sum += nums[j]-nums[i];
            i++;
           
        }
        return count;
    }
}