class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        if(nums[0]==k) count++;
        for(int i =1 ; i<n ; i++){
            nums[i]+=nums[i-1];
             if(nums[i]==k) count++;
        }
        for(int i = 0 ;i<n-1 ; i++){
            for(int j = i+1 ; j<n ; j++){
                if(nums[j]-nums[i]==k) count++;
            }
        }
        return count;
    }
}