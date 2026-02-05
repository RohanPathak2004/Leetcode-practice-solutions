class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0 ; i<n ; i++){
            if(nums[i]==0) nums[i]--;
        }
        for(int i = 1 ; i<n ; i++) nums[i]+=nums[i-1];
        
        for(int i = 0; i <n ; i++){
            int ele = nums[i];
            int len = 0;
            if(ele==0){
                len = i+1;
            }else if(map.containsKey(ele)){
                len = i-map.get(ele);
            }else{
                map.put(ele,i);
            }
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}