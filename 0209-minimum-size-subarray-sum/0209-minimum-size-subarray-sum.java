class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int minW = n+1;
        int sum = 0;
        while(j<n){
            sum = sum+nums[j];
            if(sum>=target){
                int window = j-i+1;
                while(i<n&&sum>target)
                {
                    sum = sum-nums[i];
                    i++;
                   if(sum>=target)  window = j-i+1;
                }
                minW = Math.min(minW,window);
            }
            j++;
        }
        // System.out.println(7>7);
        return  minW==n+1?0:minW;

    }
}