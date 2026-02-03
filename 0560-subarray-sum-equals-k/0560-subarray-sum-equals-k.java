class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            if (nums[0] == k)
                return 1;
            return 0;
        }

        int count = 0;

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];

        }
        HashMap<Integer, Integer> map = new HashMap<>();
        // map.put(0, 1);
        for (int i = 0; i < n; i++) {
            int a = nums[i];
            int rem = nums[i]-k;
            if(a==k) count++;
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.compute(a,(key,value)->value==null?1:value+1);
        }
        return count;
        
    }
}