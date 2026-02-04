class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 1; i<n ; i++)
        {
            nums[i]+=nums[i-1];
        }
        map.put(0,1);
        for(int i = 0 ; i <n ; i++)
        {
            int ele = nums[i];
            int rem = ele%k;
            if(rem<0) rem = (rem+k)%k;
            if(map.containsKey(rem)){
                count+=map.get(rem);
                
            }
            map.compute(rem,(key,value)->value==null?1:value+1);

        }
        return count;
    }
}