class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long maxSum = 0;
        long s = 0;
        while (j < k) {
            map.compute(nums[j],(key,value)->value==null?1:value+1);
            s+=nums[j];
            j++;
        }
        if(map.size()==k) maxSum = Math.max(maxSum,s);
        j--;
        while (j < n) {
            if (map.size() == k) {
                maxSum = Math.max(s, maxSum);
            }
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0) map.remove(nums[i]);
            j++;
            if(j<n) map.compute(nums[j],(key,value)->value==null?1:value+1);
            if(j<n) s += nums[j]-nums[i];
            i++;
        }
        return maxSum;
    }
}