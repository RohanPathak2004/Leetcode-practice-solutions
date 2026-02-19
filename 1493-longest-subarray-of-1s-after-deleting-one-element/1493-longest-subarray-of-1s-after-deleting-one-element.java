class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int z = 0;
        int maxLen = 0;
        while(j<n){
            if(nums[j]==0) z++;
            if(z==1) maxLen = Math.max(maxLen,j-i);
            while(z>1){
                if(nums[i]==0) z--;
                i++;
            }
            maxLen = Math.max(maxLen,j-i);
            j++;
        }

        return maxLen;
    }
}