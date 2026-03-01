class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxPro = Integer.MIN_VALUE;
        int currPro = 1;
        for(int i = 0 ; i<n ;i++){
            if(nums[i]==0){
                maxPro = Math.max(0,maxPro);
                currPro = 1;
            }else{
                currPro = currPro*nums[i];
                maxPro = Math.max(currPro,maxPro);
            }
        }
        currPro = 1;
        for(int i = n-1 ; i>=0 ;i--){
            if(nums[i]==0){
                maxPro = Math.max(0,maxPro);
                currPro = 1;
            }else{
                currPro = currPro*nums[i];
                maxPro = Math.max(currPro,maxPro);
            }
        }
        return maxPro;
    }
}