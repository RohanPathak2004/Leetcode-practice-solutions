class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for(int i = 1;i<n ; i++)
        {
            nums[i] += nums[i-1];
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0]%k,1);
        map.put(0,1);
        for(int i = 1; i<n ; i++)
        {
            int rem = nums[i]%k;
            if(map.containsKey(rem)){ 
                 map.compute(rem,(key,value)->value==null?1:value+1);
                 
                 if(rem==0) return true;
                 if(map.get(rem)==2){
                    int prevRem = nums[i-1]%k;
                    if(rem != prevRem) return true;
                 }else if(map.get(rem)>2) return true;
            }
            map.compute(rem,(key,value)->value==null?1:value+1);
        }
        return false;
    }
}